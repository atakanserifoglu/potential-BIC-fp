package com.potential.bic.fp.Timing;

public class SharedResource {
    private int counter = 0;

    public void incrementCounter() {
        int current = counter;
        // Simulate some processing that could lead to a context switch
        try {
            Thread.sleep(100); // Simulate delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        counter = current + 1;
    }

    public int getCounter() {
        return counter;
    }
}

