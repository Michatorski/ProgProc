package org.iesfm.concurrency.incdec.semaphore;

import java.util.concurrent.Semaphore;

public class IncrementSyncTask implements Runnable {
    private Accumulator accumulator;
    private int times;
    private Semaphore semaphore;

    public IncrementSyncTask(Accumulator accumulator, int times, Semaphore semaphore) {
        this.accumulator = accumulator;
        this.times = times;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            try {
                semaphore.acquire();
                accumulator.inc();
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
