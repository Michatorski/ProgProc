package org.iesfm.ioc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Scanner;

public class InstitutoFileScanner {

    private final static Logger log = LoggerFactory.getLogger(InstitutoFileScanner.class);

    public File getFile() {
        Scanner scanner = new Scanner(System.in);
        log.info("Introduce el path al archivo del insituto");
        String filePath = scanner.nextLine();
        return new File(filePath);
    }
}
