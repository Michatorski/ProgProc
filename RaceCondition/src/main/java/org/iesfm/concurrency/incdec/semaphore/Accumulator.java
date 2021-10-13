package org.iesfm.concurrency.incdec.semaphore;

public class Accumulator {
    private int value = 0;

    public void inc() {
        value++;
    }

    public void dec() {
        value--;
    }

    public int getValue() {
        return value;
    }
}
