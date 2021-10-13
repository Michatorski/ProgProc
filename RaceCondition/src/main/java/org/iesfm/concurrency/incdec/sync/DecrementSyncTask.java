package org.iesfm.concurrency.incdec.sync;

public class DecrementSyncTask implements Runnable {
    private Accumulator accumulator;
    private int times;

    public DecrementSyncTask(Accumulator accumulator, int times) {
        this.accumulator = accumulator;
        this.times = times;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            accumulator.dec();

        }
    }
}
