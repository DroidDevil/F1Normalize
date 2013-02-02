package com.droiddevil.f1normalize.network;

import org.scribe.model.OAuthRequest;

import com.droiddevil.f1normalize.F1NProtocol;

public abstract class AbstractNetworkOAuthTaskF1Paginate<T> extends AbstractNetworkOAuthTaskF1<T> {

    private int mPage = 0;

    private int mRecordsPerPage;

    public AbstractNetworkOAuthTaskF1Paginate(F1NProtocol protocol, int page, int recordsPerPage) {
        super(protocol);
        mPage = page;
        mRecordsPerPage = recordsPerPage;
    }

    @Override
    final protected OAuthRequest getRequest() {
        OAuthRequest request = createRequest();
        if (mPage > 0) {
            request.addQuerystringParameter("page", String.valueOf(mPage));
        }
        if (mRecordsPerPage > 0) {
            request.addQuerystringParameter("recordsPerPage", String.valueOf(mRecordsPerPage));
        }
        return request;
    }

    public int getPageNumber() {
        return mPage;
    }

    public void setPageNumber(int page) {
        mPage = page;
    }

    public int getRecordsPerPage() {
        return mRecordsPerPage;
    }

    public void setRecordsPerPage(int recordsPerPage) {
        mRecordsPerPage = recordsPerPage;
    }

    abstract OAuthRequest createRequest();

}
