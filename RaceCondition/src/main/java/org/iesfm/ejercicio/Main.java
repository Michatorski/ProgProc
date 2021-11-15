package org.iesfm.ejercicio;

import java.util.concurrent.Semaphore;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(2);

        Thread tHola = new Thread(new MakingThreads("hola", semaphore));
        Thread tAdios = new Thread(new MakingThreads("adios", semaphore));

        semaphore.acquire(2);
        tHola.start();
        semaphore.release(1);

        semaphore.acquire(1);
        System.out.println("Ya ha terminado");
        semaphore.release(2);

        semaphore.acquire(2);
        tAdios.start();
        semaphore.release(1);

        tHola.join();
        tAdios.join();

    }
}
