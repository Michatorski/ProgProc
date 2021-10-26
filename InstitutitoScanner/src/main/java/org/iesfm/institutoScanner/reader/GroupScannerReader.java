package org.iesfm.institutoScanner.reader;

import org.iesfm.institutoScanner.Group;
import org.iesfm.institutoScanner.ScannerUtils;
import org.iesfm.institutoScanner.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GroupScannerReader {

    private final static Logger log = LoggerFactory.getLogger(GroupScannerReader.class);

    private Scanner scanner;
    private StudentScannerReader studentScannerReader;
    private ScannerUtils scannerUtils;

    public GroupScannerReader(Scanner scanner, StudentScannerReader studentScannerReader, ScannerUtils scannerUtils) {
        this.scanner = scanner;
        this.studentScannerReader = studentScannerReader;
        this.scannerUtils = scannerUtils;
    }

    public Group readScanGroup() {

        log.info("Introduce letra del grupo ");
        String letra = scanner.nextLine();
        log.info("Introduce curso del grupo");
        String curso = scanner.nextLine();
        log.info("¿Cuantos estidiantes tiene el grupo? ");
        int showAlumnos = scanner.nextInt();
        scanner.nextLine();
        List<Student> alumnos = new LinkedList<>();

        for (int i = 0; i < showAlumnos; i++) {
            alumnos.add(studentScannerReader.readScanStudent());
        }
        return new Group(letra, curso, alumnos);
    }
}
