package org.iesfm.ejercicio;

import java.util.concurrent.Semaphore;

public class MakingThreads implements Runnable {
    private String message;
    private Semaphore semaphore;

    public MakingThreads(String message, Semaphore semaphore) {
        this.message = message;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {

        try{
            semaphore.acquire();
            for (int i = 0; i < 10; i++) {
                Thread.sleep(300);
                System.out.println(message);
            }
            semaphore.release();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
