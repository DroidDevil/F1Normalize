package com.droiddevil.f1normalize.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.ParseException;
import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;

import com.droiddevil.f1normalize.F1NProtocol;
import com.google.gson.stream.JsonReader;

public abstract class AbstractNetworkOAuthTaskF1<T> extends AbstractNetworkOAuthTask<T> {

    private static final boolean DEBUG = true;

    private F1NProtocol mProtocol;

    public AbstractNetworkOAuthTaskF1(F1NProtocol protocol, NetworkDataHandler<T> handler) {
        super(handler);
        mProtocol = protocol;
    }

    @Override
    protected OAuthService getService() {
        return mProtocol.getF1Service();
    }

    @Override
    protected Token getToken() {
        return mProtocol.getToken();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.droiddevil.f1normalize.network.AbstractNetworkOAuthTask#inflateData(java.io.InputStream)
     */
    @Override
    protected T inflateData(InputStream stream) throws IOException, ParseException {
        JsonReader reader = new JsonReader(new InputStreamReader(stream));
        T obj = mProtocol.getGson().fromJson(reader, getTypeClass());
        reader.close();

        if (DEBUG) {
            System.out.println(mProtocol.getGson().toJson(obj));
        }

        return obj;
    }

    /**
     * Get the class for the data model.
     * 
     * @return The model class.
     */
    abstract protected Class<T> getTypeClass();

}
