package com.droiddevil.f1normalize;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import com.droiddevil.f1normalize.model.Household;
import com.droiddevil.f1normalize.model.HouseholdSearch;
import com.droiddevil.f1normalize.network.F1HouseholdSearchTask;
import com.droiddevil.f1normalize.network.NetworkDataError;
import com.droiddevil.f1normalize.network.NetworkDataHandler;

public class F1LoaderHousehold {

    private static final int RECORDS_PER_PAGE = 50;

    private F1NProtocol mProtocol;

    private Set<Household> mData = Collections.synchronizedSet(new HashSet<Household>());

    private AtomicInteger mCounter = new AtomicInteger(1);

    private boolean mIsFirstLoad = true;

    final NetworkDataHandler<HouseholdSearch> handler = new NetworkDataHandler<HouseholdSearch>() {

        @Override
        public void onDataReady(HouseholdSearch data) {
            if (mIsFirstLoad) {
                mIsFirstLoad = false;

                for (int i = 0; i < data.getResults().getAdditionalPages(); i++) {
                    mCounter.incrementAndGet();
                    createTask(i + 2).execute(this);
                }
            }

            mData.addAll(data.getResults().getHousehold());
        }

        @Override
        public void onError(NetworkDataError error, int errorCode) {
            System.err.println(error);
        }

        @Override
        public void onStopLoad() {
            int count = mCounter.decrementAndGet();
            if (count == 0) {
                synchronized (mData) {
                    mData.notifyAll();
                }
            }
        }
    };

    public void load(F1NProtocol protocol) {
        mProtocol = protocol;
        createTask(1).execute(handler);

        try {
            synchronized (mData) {
                mData.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Loaded " + mData.size() + " Households");
    }

    private F1HouseholdSearchTask createTask(int page) {
        return new F1HouseholdSearchTask(new Date(0), page, RECORDS_PER_PAGE, mProtocol);
    }
}
