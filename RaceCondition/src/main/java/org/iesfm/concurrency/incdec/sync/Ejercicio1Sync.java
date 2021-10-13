package org.iesfm.concurrency.incdec.sync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ejercicio1Sync {
    private static Logger log = LoggerFactory.getLogger(Ejercicio1Sync.class);

    public static void main(String[] args) {
        Accumulator accumulator = new Accumulator();
        Thread incrementThread = new Thread(
                new IncrementSyncTask(accumulator, 1000)
        );
        Thread decrementThread = new Thread(
                new DecrementSyncTask(accumulator, 1000)
        );

        incrementThread.start();
        decrementThread.start();

        try {
            incrementThread.join();
            decrementThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("El resultado es " + accumulator.getValue());

    }
}
