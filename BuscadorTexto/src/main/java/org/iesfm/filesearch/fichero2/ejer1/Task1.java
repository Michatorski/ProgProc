package org.iesfm.filesearch.fichero2.ejer1;

public class Task1 implements Runnable{

    private int n;
    private String word;
    private int timeToSleep;

    public Task1(int n, String word, int timeToSleep) {
        this.n = n;
        this.word = word;
        this.timeToSleep = timeToSleep;
    }

    @Override
    public void run() {
            for (int i = 0; i < n; i++) {
                System.out.println(word);
            }
            try {
                Thread.sleep(timeToSleep);
            } catch (InterruptedException e){
                e.printStackTrace();
            }

    }
}
