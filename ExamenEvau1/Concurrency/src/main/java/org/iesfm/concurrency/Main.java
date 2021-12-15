package org.iesfm.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {


    private final static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        log.info("Cuantos clientes en una fila");


        Queue queue = new Queue(scanner.nextInt());

        Thread t1 = new Thread(new CashierTask(queue));
        t1.start();
        Thread.sleep(1000);
        Thread t2 = new Thread(new CashierTask(queue));
        t2.start();

        t1.join();
        t2.join();
        log.info("La fila tiene " + queue);
    }
}
