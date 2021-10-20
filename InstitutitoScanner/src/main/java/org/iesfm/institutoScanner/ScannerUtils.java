package org.iesfm.institutoScanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerUtils {
    private final static Logger log = LoggerFactory.getLogger(ScannerUtils.class);

    private Scanner scanner;

    public ScannerUtils(Scanner scanner) {
        this.scanner = scanner;
    }

    public int scanPositive(){
        int num = scanNumber();
        return num;
    }

    public int scanNumber() {

        // Como todavía no tenemos numero, empezamos con null
        Integer num = null;
        // Mientra el usuario no haya metido un número
        while (num == null)
            try {
                log.info("Introduce numero: ");
                num = scanner.nextInt();
                scanner.nextLine();
                return num;
            } catch (InputMismatchException e) {
                log.error("Error, no es un número");
            } finally {
                {
                    // Al final del try y catch hacemos un nextLine
                    scanner.nextLine();
                }
            }
        return num;
    }
}
