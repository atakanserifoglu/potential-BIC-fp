package com.potential.bic.fp.Timing;

public class CounterThread extends Thread {
    private SharedResource sharedResource;

    public CounterThread(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        sharedResource.incrementCounter();
    }
}

