package com.droiddevil.f1normalize.network;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;

import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;

/**
 * The base level class for all OAuth network requests. Tasks extending from this run in a fixed size thread pool
 * reserved for network data.
 * 
 * @author tperrien
 * 
 * @param <T>
 *            The type of data that is being fetched.
 */
public abstract class AbstractNetworkOAuthTask<T> implements Runnable {

    private static final int CORE_POOL_SIZE = 5;

    private static final int MAXIMUM_POOL_SIZE = 128;

    private static final int KEEP_ALIVE = 1;

    /**
     * Accept-Encoding HTTP header name. Request only.
     */
    private static final String HTTP_HEADER_ACCEPT_ENCODING = "Accept-Encoding";

    /**
     * Content-Encoding HTTP header name. Response only.
     */
    private static final String HTTP_HEADER_CONTENT_ENCODING = "Content-Encoding";

    /**
     * GZip HTTP playload encoding. Used in Accept-Encoding and Content-Encoding headers
     */
    private static final String HTTP_PAYLOAD_ENCODING_GZIP = "gzip";

    private static final ThreadFactory sThreadFactory = new ThreadFactory() {
        private final AtomicInteger mCount = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "NetworkTask #" + mCount.getAndIncrement());
        }
    };

    private static final BlockingQueue<Runnable> sPoolWorkQueue = new LinkedBlockingQueue<Runnable>(
            10);

    public static final ExecutorService THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(
            CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE, TimeUnit.SECONDS, sPoolWorkQueue,
            sThreadFactory);

    private NetworkDataHandler<T> mDataHandler;

    private Future<?> mFuture;

    private boolean mCancelled;

    /**
     * Adds this task to the task executor service for processing.
     * 
     * @param dataHandler
     *            The data handler for this task.
     */
    public void execute(final NetworkDataHandler<T> dataHandler) {
        mDataHandler = new NetworkDataHandler<T>() {

            @Override
            public void onDataReady(final T data) {
                if (!mCancelled) {
                    dataHandler.onDataReady(data);
                    dataHandler.onStopLoad();
                }
            }

            @Override
            public void onError(final NetworkDataError error, final int errorCode) {
                if (!mCancelled) {
                    dataHandler.onError(error, errorCode);
                    dataHandler.onStopLoad();
                }
            }

            @Override
            public void onStopLoad() {
                throw new IllegalStateException("Don't call me ever!");
            }
        };

        mFuture = THREAD_POOL_EXECUTOR.submit(this);
    }

    public void cancel() {
        mCancelled = true;
        if (mFuture != null) {
            mFuture.cancel(true);
        }
    }

    @Override
    public void run() {
        do {
            try {
                boolean httpError = false;
                boolean parseError = false;
                int statusCode = 0;
                T data = null;

                OAuthRequest request = getRequest();

                // Gzip
                request.addHeader(HTTP_HEADER_ACCEPT_ENCODING, HTTP_PAYLOAD_ENCODING_GZIP);

                OAuthService service = getService();
                service.signRequest(getToken(), request);

                // Send request
                Response response = request.send();
                if (mCancelled) {
                    break;
                }

                InputStream stream = null;
                try {
                    statusCode = response.getCode();
                    if (statusCode == HttpStatus.SC_OK) {
                        InputStream rawContent = response.getStream();

                        // Gzip
                        String contentEncoding = response.getHeader(HTTP_HEADER_CONTENT_ENCODING);
                        if (contentEncoding != null
                                && HTTP_PAYLOAD_ENCODING_GZIP.equalsIgnoreCase(contentEncoding)) {
                            rawContent = new GZIPInputStream(rawContent);
                        }

                        stream = new BufferedInputStream(rawContent);
                        try {
                            data = inflateData(stream);
                        } catch (ParseException pe) {
                            parseError = true;
                        }
                    } else {
                        httpError = true;
                    }
                } catch (IOException ioe) {
                    httpError = true;
                } finally {
                    if (stream != null) {
                        try {
                            stream.close();
                        } catch (IOException e) {
                        }
                    }
                }

                if (mCancelled) {
                    break;
                }

                try {
                    if (parseError) {
                        mDataHandler.onError(NetworkDataError.PARSE_ERROR, 0);
                    } else if (httpError) {
                        mDataHandler.onError(NetworkDataError.IO_ERROR, statusCode);
                    } else {
                        mDataHandler.onDataReady(data);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    mDataHandler.onError(NetworkDataError.UNKNOWN, 0);
                }
            } catch (Exception e) {
                e.printStackTrace();
                mDataHandler.onError(NetworkDataError.UNKNOWN, 0);
            }
        } while (false);
    }

    /**
     * Get the request.
     * 
     * @return The request to process.
     */
    abstract protected OAuthRequest getRequest();

    /**
     * Get the service.
     * 
     * @return The service.
     */
    abstract protected OAuthService getService();

    /**
     * Get the token.
     * 
     * @return The token.
     */
    abstract protected Token getToken();

    /**
     * Read stream and parse data.
     * 
     * @return Parsed result.
     */

    abstract protected T inflateData(InputStream stream) throws IOException, ParseException;

}