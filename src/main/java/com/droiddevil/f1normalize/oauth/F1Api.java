package com.droiddevil.f1normalize.oauth;

import org.scribe.builder.api.DefaultApi10a;
import org.scribe.model.Token;

public class F1Api extends DefaultApi10a {

    private static final String URL_REQUEST_TOKEN = "https://droiddevil.staging.fellowshiponeapi.com/v1/Tokens/RequestToken";

    private static final String URL_AUTHORIZE = "https://droiddevil.staging.fellowshiponeapi.com/v1/PortalUser/Login?oauth_token=%s";

    private static final String URL_ACCESS_TOKEN = "https://droiddevil.staging.fellowshiponeapi.com/v1/Tokens/AccessToken";

    @Override
    public String getRequestTokenEndpoint() {
        return URL_REQUEST_TOKEN;
    }

    @Override
    public String getAccessTokenEndpoint() {
        return URL_ACCESS_TOKEN;
    }

    @Override
    public String getAuthorizationUrl(Token requestToken) {
        return String.format(URL_AUTHORIZE, requestToken.getToken());
    }

}