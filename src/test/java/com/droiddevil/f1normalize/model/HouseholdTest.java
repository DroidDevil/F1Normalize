package com.droiddevil.f1normalize.model;

import java.util.Map;

import junit.framework.TestCase;

import com.droiddevil.f1normalize.util.GsonUtil;

public class HouseholdTest extends TestCase {

    @SuppressWarnings("unchecked")
    public void testModel() {
        String data = "{\"household\":{\"@id\":\"1552366\",\"@uri\":\"https://demo.fellowshiponeapi.com/v1/Households/1552366\",\"@oldID\":\"1340151\",\"@hCode\":\"CYQVRnq3sKZi8rBKr7IGyg==\",\"householdName\":\"Greg and Kristin Cannon\",\"householdSortName\":\"Cannon\",\"householdFirstName\":\"Greg and Kristin\",\"lastSecurityAuthorization\":null,\"lastActivityDate\":\"2006-09-09T17:00:00\",\"createdDate\":null,\"lastUpdatedDate\":\"2008-11-04T13:15:14\"}}";
        Map<String, Object> r = GsonUtil.getFromJSON(data, Map.class);
        String innerJson = GsonUtil.toJSON(r.get("household"));
        Household household = GsonUtil.getFromJSON(innerJson, Household.class);
        assertEquals(1552366, household.getId());
        assertNotNull(household.getUri());
    }

}
