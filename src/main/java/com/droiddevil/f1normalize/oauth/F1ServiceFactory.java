package com.droiddevil.f1normalize.oauth;

import java.util.Properties;

import org.scribe.builder.ServiceBuilder;
import org.scribe.oauth.OAuthService;

public class F1ServiceFactory {

    private static final String PROP_KEY = "oauth.consumer_key";

    private static final String PROP_SECRET = "oauth.consumer_secret";

    public static OAuthService create(Properties config) {
        String key = config.getProperty(PROP_KEY);
        String secret = config.getProperty(PROP_SECRET);

        OAuthService service = new ServiceBuilder().provider(new F1Api()).apiKey(key)
                .apiSecret(secret).build();

        return service;
    }

}
