package com.droiddevil.f1normalize.loader;

import java.util.Date;
import java.util.List;

import com.droiddevil.f1normalize.F1NProtocol;
import com.droiddevil.f1normalize.model.Household;
import com.droiddevil.f1normalize.model.HouseholdSearch;
import com.droiddevil.f1normalize.network.F1HouseholdSearchTask;

public class F1LoaderHousehold extends
        AbstractDataLoader<Household, HouseholdSearch, F1HouseholdSearchTask> {

    private static final int RECORDS_PER_PAGE = 50;

    private F1NProtocol mProtocol;

    public F1LoaderHousehold(F1NProtocol protocol) {
        mProtocol = protocol;
    }

    @Override
    protected F1HouseholdSearchTask createTask(int page) {
        return new F1HouseholdSearchTask(new Date(0), page, RECORDS_PER_PAGE, mProtocol);
    }

    @Override
    protected int getAdditionalPages(HouseholdSearch data) {
        return data.getResults().getAdditionalPages();
    }

    @Override
    protected List<Household> getAllRecords(HouseholdSearch data) {
        return data.getResults().getHousehold();
    }
}
