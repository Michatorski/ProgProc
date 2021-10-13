package org.iesfm.filesearch.taskEjer;

public class EjerTask2 implements Runnable{

    private String words;
    private int n;
    private long timeToSleep;

    public EjerTask2(String words, int n, long timeToSleep) {
        this.words = words;
        this.n = n;
        this.timeToSleep= timeToSleep;
    }

    @Override
    public void run() {

    }
}
