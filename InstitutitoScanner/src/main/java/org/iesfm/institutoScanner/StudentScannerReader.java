package org.iesfm.institutoScanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class StudentScannerReader {

    private final static Logger log = LoggerFactory.getLogger(StudentScannerReader.class);


    private Scanner scanner;
    private ScannerUtils scannerUtils;

    public StudentScannerReader(Scanner scanner, ScannerUtils scannerUtils) {
        this.scanner = scanner;
        this.scannerUtils = scannerUtils;
    }

    public Student readScanStudent() {

        log.info("Introduce nombre del alumno: ");
        String  name = scanner.nextLine();
        log.info("Introduce apellido del alumno: ");
        String surname = scanner.nextLine();
        log.info("Introduce NIF del alumno: ");
        String nif = scanner.nextLine();

        return new Student(nif, name, surname);
    }
}
