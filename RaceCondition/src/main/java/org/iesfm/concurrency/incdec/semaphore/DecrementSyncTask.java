package org.iesfm.concurrency.incdec.semaphore;

import java.util.concurrent.Semaphore;

public class DecrementSyncTask implements Runnable {
    private Accumulator accumulator;
    private int times;
    private Semaphore semaphore;

    public DecrementSyncTask(Accumulator accumulator, int times, Semaphore semaphore) {
        this.accumulator = accumulator;
        this.times = times;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            try {
                semaphore.acquire();
                accumulator.dec();
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
