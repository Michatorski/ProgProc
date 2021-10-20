package org.iesfm.institutoScanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class InstitutoScannerReader {
    private final static Logger log = LoggerFactory.getLogger(InstitutoScannerReader.class);

    private Scanner scanner;
    private GroupScannerReader groupScannerReader;

    public InstitutoScannerReader(Scanner scanner, GroupScannerReader groupScannerReader) {
        this.scanner = scanner;
        this.groupScannerReader = groupScannerReader;
    }

    public Instituto readScanGroup() {

        log.info("Introduce nombre del instituto: ");
        String name = scanner.nextLine();
        log.info("Introduce numero de grupos: ");
        int showGrupos = scanner.nextInt();
        scanner.nextLine();
        List<Group> grupos = new LinkedList<>();

        for (int i = 0; i < showGrupos; i++) {
            grupos.add(groupScannerReader.readScanGroup());
        }
        return new Instituto(name, grupos);
    }
}
