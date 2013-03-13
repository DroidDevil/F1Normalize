package com.droiddevil.f1normalize.loader;

import java.util.Date;
import java.util.List;

import com.droiddevil.f1normalize.F1NProtocol;
import com.droiddevil.f1normalize.model.PeopleSearch;
import com.droiddevil.f1normalize.model.Person;
import com.droiddevil.f1normalize.network.F1PeopleSearchTask;

public class F1LoaderPeople extends AbstractDataLoader<Person, PeopleSearch, F1PeopleSearchTask> {

    private static final int RECORDS_PER_PAGE = 50;

    private F1NProtocol mProtocol;

    public F1LoaderPeople(F1NProtocol protocol) {
        mProtocol = protocol;
    }

    @Override
    protected F1PeopleSearchTask createTask(int page) {
        return new F1PeopleSearchTask(new Date(0), page, RECORDS_PER_PAGE, mProtocol);
    }

    @Override
    protected int getAdditionalPages(PeopleSearch data) {
        return data.getResults().getAdditionalPages();
    }

    @Override
    protected List<Person> getAllRecords(PeopleSearch data) {
        return data.getResults().getPerson();
    }
}
