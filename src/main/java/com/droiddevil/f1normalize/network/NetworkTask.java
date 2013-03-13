package com.droiddevil.f1normalize.network;

public interface NetworkTask<T> extends Runnable {

    void execute(final NetworkDataHandler<T> dataHandler);

}
