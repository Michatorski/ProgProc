package org.iesfm.concurrency.incdec.semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Semaphore;

public class Main {
    private static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        Accumulator accumulator = new Accumulator();
        Thread incrementThread = new Thread(
                new IncrementSyncTask(accumulator, 1000, semaphore)
        );
        Thread decrementThread = new Thread(
                new DecrementSyncTask(accumulator, 1000, semaphore)
        );

        incrementThread.start();
        decrementThread.start();

        try {
            incrementThread.join();
            decrementThread.join();
        } catch (InterruptedException e) {
            log.error("", e);
        }

        log.info("El resultado es " + accumulator.getValue());
    }
}
