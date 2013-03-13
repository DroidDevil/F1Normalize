package com.droiddevil.f1normalize.loader;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import com.droiddevil.f1normalize.network.NetworkDataError;
import com.droiddevil.f1normalize.network.NetworkDataHandler;
import com.droiddevil.f1normalize.network.NetworkTask;

public abstract class AbstractDataLoader<DATA, TASKDATA, TASK extends NetworkTask<TASKDATA>> {

    private Set<DATA> mData = Collections.synchronizedSet(new HashSet<DATA>());

    private AtomicInteger mCounter = new AtomicInteger(1);

    private boolean mIsFirstLoad = true;

    final NetworkDataHandler<TASKDATA> handler = new NetworkDataHandler<TASKDATA>() {

        @Override
        public void onDataReady(TASKDATA data) {
            if (mIsFirstLoad) {
                mIsFirstLoad = false;

                int additionalPages = getAdditionalPages(data);

                for (int i = 0; i < additionalPages; i++) {
                    mCounter.incrementAndGet();
                    createTask(i + 2).execute(this);
                }
            }

            mData.addAll(getAllRecords(data));
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

    public void load() {
        createTask(1).execute(handler);

        try {
            synchronized (mData) {
                mData.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Loaded " + mData.size() + " records");
    }

    public Set<DATA> getData() {
        return mData;
    }

    protected abstract TASK createTask(int page);

    protected abstract int getAdditionalPages(TASKDATA data);

    protected abstract List<DATA> getAllRecords(TASKDATA data);

}
