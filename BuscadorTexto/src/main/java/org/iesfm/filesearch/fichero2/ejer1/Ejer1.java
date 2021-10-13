package org.iesfm.filesearch.fichero2.ejer1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ejer1 {

    public static Logger log = LoggerFactory.getLogger(Ejer1.class);

    public static void main(String[] args) {

        Thread t1 = new Thread(new Task1(100, "hola", 1000));
        t1.start();

        Thread t2 = new Thread(new Task1(50, "adios", 1000));
        t2.start();
    }
}
