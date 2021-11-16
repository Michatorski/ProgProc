package org.iesfm.pingPong;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Semaphore pingSemaphore = new Semaphore(1);
        Semaphore pongSemaphore = new Semaphore(1);



        Thread pingThread = new Thread(new PingTask(pingSemaphore,pongSemaphore));
        Thread pongThread = new Thread(new PongTask(pingSemaphore,pongSemaphore));

        try{
            pongSemaphore.acquire(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        pingThread.start();
        pongThread.start();

        try {
            pingThread.join();
            pongThread.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }




    }
}
