package com.droiddevil.f1normalize.model;

import java.util.Map;

import junit.framework.TestCase;

import com.droiddevil.f1normalize.util.GsonUtil;

public class PersonTest extends TestCase {

    @SuppressWarnings("unchecked")
    public void testModel() {
        String data = "{\"person\":{\"@id\":\"22114941\",\"@uri\":\"https://demo.fellowshiponeapi.com/v1/People/22114941\",\"@imageURI\":\"\",\"@oldID\":\"\",\"@iCode\":\"rD94LTAKe4ROXa50SLH7oQ==\",\"@householdID\":\"14338522\",\"@oldHouseholdID\":\"\",\"title\":null,\"salutation\":null,\"prefix\":null,\"firstName\":\"Nicholas\",\"lastName\":\"Floyd\",\"suffix\":null,\"middleName\":\"A\",\"goesByName\":\"Nick\",\"formerName\":null,\"gender\":\"Male\",\"dateOfBirth\":\"1976-08-13T00:00:00\",\"maritalStatus\":\"Married\",\"householdMemberType\":{\"@id\":\"1\",\"@uri\":\"https://demo.fellowshiponeapi.com/v1/People/HouseholdMemberTypes/1\",\"name\":\"Head\"},\"isAuthorized\":\"true\",\"status\":{\"@id\":\"1\",\"@uri\":\"https://demo.fellowshiponeapi.com/v1/People/Statuses/1\",\"name\":\"Member\",\"comment\":null,\"date\":null,\"subStatus\":{\"@id\":\"1\",\"@uri\":\"\",\"name\":null}},\"occupation\":{\"@id\":\"1\",\"@uri\":\"\",\"name\":null,\"description\":null},\"employer\":\"Fellowship Technologies\",\"school\":{\"@id\":\"1\",\"@uri\":\"\",\"name\":null},\"denomination\":{\"@id\":\"1\",\"@uri\":\"\",\"name\":null},\"formerChurch\":null,\"barCode\":\"dfhg\",\"memberEnvelopeCode\":\"12341234\",\"defaultTagComment\":null,\"weblink\":{\"userID\":null,\"passwordHint\":null,\"passwordAnswer\":null},\"solicit\":null,\"thank\":null,\"firstRecord\":\"2008-12-11T07:41:07\",\"lastMatchDate\":null,\"createdDate\":\"2008-12-11T07:41:08\",\"lastUpdatedDate\":\"2009-04-30T15:12:49\"}}";
        Map<String, Object> r = GsonUtil.getFromJSON(data, Map.class);
        String innerJson = GsonUtil.toJSON(r.get("person"));
        Person person = GsonUtil.getFromJSON(innerJson, Person.class);
        assertEquals(22114941, person.getId());
        assertNotNull(person.getUri());
    }

}
