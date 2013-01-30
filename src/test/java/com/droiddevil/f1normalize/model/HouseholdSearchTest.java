package com.droiddevil.f1normalize.model;

import junit.framework.TestCase;

import com.droiddevil.f1normalize.util.GsonUtil;

public class HouseholdSearchTest extends TestCase {

    public void testModel() {
        String data = "{\"results\":{\"@count\":\"3\",\"@pageNumber\":\"1\",\"@totalRecords\":\"3\",\"@additionalPages\":\"0\",\"household\":[{\"@id\":\"3070691\",\"@uri\":\"https://demo.fellowshiponeapi.com/v1/Households/3070691\",\"@oldID\":\"\",\"@hCode\":\"mlB4tpIVkgyIxMA0TvX0nQ==\",\"householdName\":\"Turner Excavation\",\"householdSortName\":\"Turner Excavation\",\"householdFirstName\":null,\"lastSecurityAuthorization\":null,\"lastActivityDate\":null,\"createdDate\":null,\"lastUpdatedDate\":null},{\"@id\":\"1551398\",\"@uri\":\"https://demo.fellowshiponeapi.com/v1/Households/1551398\",\"@oldID\":\"971655\",\"@hCode\":\"urt+Ni9Wu8/Ba/c9xvmnTQ==\",\"householdName\":\"Turner Harris\",\"householdSortName\":\"Harris\",\"householdFirstName\":\"Turner\",\"lastSecurityAuthorization\":null,\"lastActivityDate\":\"2006-01-27T12:25:00\",\"createdDate\":null,\"lastUpdatedDate\":\"2006-01-31T00:08:53\"},{\"@id\":\"2695854\",\"@uri\":\"https://demo.fellowshiponeapi.com/v1/Households/2695854\",\"@oldID\":\"\",\"@hCode\":\"uvO24oj2im1NxJIZysniLQ==\",\"householdName\":\"Turner Pierce\",\"householdSortName\":\"Pierce\",\"householdFirstName\":\"Turner\",\"lastSecurityAuthorization\":\"2005-03-17T17:15:53\",\"lastActivityDate\":\"2006-01-27T12:25:00\",\"createdDate\":null,\"lastUpdatedDate\":\"2008-11-04T17:28:57\"}]}}";
        HouseholdSearch search = GsonUtil.getFromJSON(data,
                HouseholdSearch.class);
        assertNotNull(search);
    }

}
