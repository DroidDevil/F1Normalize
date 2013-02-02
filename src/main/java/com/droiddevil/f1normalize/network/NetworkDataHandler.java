package com.droiddevil.f1normalize.network;

import com.droiddevil.f1normalize.temp.AbstractNetworkDataTask;

/**
 * Interface used to define a callback handler that communicates with a {@link AbstractNetworkDataTask}.
 * 
 * @author tperrien
 * 
 * @param <T>
 */
public interface NetworkDataHandler<T> {

    /**
     * This is called when the requested data is ready.
     * 
     * @param data
     *            The data
     */
    void onDataReady(T data);

    /**
     * This is called when the requested data not modified or the same as before.
     * 
     * @param data
     *            The data
     */
    void onDataNotModified();

    /**
     * This is called when the response signals an error.
     */
    void onError(NetworkDataError error, int errorCode);

    /**
     * Load stop.
     */
    void onStopLoad();
}
