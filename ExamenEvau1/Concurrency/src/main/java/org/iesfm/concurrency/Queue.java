package org.iesfm.concurrency;

public class Queue {
    private int value;

    public Queue(int value) {
        this.value = value;
    }

    public int getValue(){
    return value;
    }

    public void dec(){
        value--;
    }
}
