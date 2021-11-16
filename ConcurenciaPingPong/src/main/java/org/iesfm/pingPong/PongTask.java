package org.iesfm.pingPong;

import java.util.concurrent.Semaphore;

public class PongTask implements  Runnable{

    private String pong = "Pong!";
    private Semaphore pingSemaphore;
    private Semaphore pongSemaphore;

    public PongTask(Semaphore pingSemaphore, Semaphore pongSemaphore) {
        this.pingSemaphore = pingSemaphore;
        this.pongSemaphore = pongSemaphore;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                pongSemaphore.acquire(1);
                System.out.println(pong);
                pingSemaphore.release(1);
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
