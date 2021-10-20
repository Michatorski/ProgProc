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

        Integer num = null;
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
                    scanner.nextLine();
                }
            }
        return num;
    }
}
