package org.iesfm.pingPong;

import java.util.concurrent.Semaphore;

public class PingTask implements Runnable {
    private String ping = "Ping!";
    private Semaphore pingSemaphore;
    private Semaphore pongSemaphore;

    public PingTask(Semaphore pingSemaphore, Semaphore pongSemaphore) {
        this.pingSemaphore = pingSemaphore;
        this.pongSemaphore = pongSemaphore;
    }

    @Override
    public void run() {

        try {
            for (int i = 0; i < 100; i++) {
                pingSemaphore.acquire(1);
                System.out.println(ping);
                pongSemaphore.release(1);
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }


    }
}
