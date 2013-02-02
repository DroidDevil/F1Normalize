package com.droiddevil.f1normalize.network;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Verb;

import com.droiddevil.f1normalize.F1NProtocol;
import com.droiddevil.f1normalize.F1NURL;
import com.droiddevil.f1normalize.model.HouseholdSearch;

public class F1HouseholdSearchTask extends AbstractNetworkOAuthTaskF1Paginate<HouseholdSearch> {

    private String mQuery;

    private Date mLastUpdatedDate;

    public F1HouseholdSearchTask(String query, int page, int recordsPerPage, F1NProtocol protocol) {
        super(protocol, page, recordsPerPage);
        mQuery = query;
    }

    public F1HouseholdSearchTask(Date lastUpdatedDate, int page, int recordsPerPage,
            F1NProtocol protocol) {
        super(protocol, page, recordsPerPage);
        mLastUpdatedDate = lastUpdatedDate;
    }

    @Override
    protected OAuthRequest createRequest() {
        OAuthRequest request = new OAuthRequest(Verb.GET, F1NURL.HOUSEHOLD_SEARCH);
        if (mQuery != null) {
            request.addQuerystringParameter("searchFor", mQuery);
        }
        if (mLastUpdatedDate != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String date = formatter.format(mLastUpdatedDate);
            request.addQuerystringParameter("lastUpdatedDate", date);
        }
        return request;
    }

    @Override
    protected Class<HouseholdSearch> getTypeClass() {
        return HouseholdSearch.class;
    }
}
