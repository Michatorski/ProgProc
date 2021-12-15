package org.iesfm.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class CashierTask implements Runnable {


    private final static Logger log = LoggerFactory.getLogger(Main.class);

    private Queue queue;

    public CashierTask(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        Scanner scanner = new Scanner(System.in);
        log.info("Tamaño fila: " + queue);
        queue.dec();
        log.info("Tamaño fila: " + queue);
    }
}
