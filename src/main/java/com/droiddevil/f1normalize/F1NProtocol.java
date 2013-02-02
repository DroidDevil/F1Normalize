package com.droiddevil.f1normalize;

import java.util.Properties;

import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;

import com.droiddevil.f1normalize.oauth.F1ServiceFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class F1NProtocol {

    private Properties mProperties;

    private OAuthService mF1Service;

    private Token mToken;

    private Gson mGson;

    public F1NProtocol(Properties properties) {
        mProperties = properties;
    }

    public synchronized OAuthService getF1Service() {
        if (mF1Service == null) {
            mF1Service = F1ServiceFactory.create(mProperties);
        }
        return mF1Service;
    }

    public synchronized Token getToken() {
        if (mToken == null) {
            final String PROP_ACCESS_TOKEN = "oauth.access_token";
            final String PROP_TOKEN_SECRET = "oauth.token_secret";

            String accessToken = mProperties.getProperty(PROP_ACCESS_TOKEN);
            String tokenSecret = mProperties.getProperty(PROP_TOKEN_SECRET);

            mToken = new Token(accessToken, tokenSecret);
        }
        return mToken;
    }

    public Gson getGson() {
        if (mGson == null) {
            mGson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").setPrettyPrinting()
                    .create();
        }
        return mGson;
    }
}
