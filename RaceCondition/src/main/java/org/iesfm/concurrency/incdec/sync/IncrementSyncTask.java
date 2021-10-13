package org.iesfm.concurrency.incdec.sync;

public class IncrementSyncTask implements Runnable {
    private Accumulator accumulator;
    private int times;

    public IncrementSyncTask(Accumulator accumulator, int times) {
        this.accumulator = accumulator;
        this.times = times;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            accumulator.inc();
        }
    }
}
