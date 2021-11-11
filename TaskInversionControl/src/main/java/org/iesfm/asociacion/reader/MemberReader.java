package org.iesfm.asociacion.reader;

import org.iesfm.asociacion.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class MemberReader {
    private final static Logger log = LoggerFactory.getLogger(MemberReader.class);

    private Scanner scanner;

    public MemberReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public Member readMember(){
        log.info("Introduce 'nif' del Student");
        String nif = scanner.nextLine();
        log.info("Introduce 'name' del Student");
        String name = scanner.nextLine();
        log.info("Introduce 'surname' del Student");
        String surname = scanner.nextLine();
        log.info("Introduce 'zipCode' del Student");
        int zipCode = scanner.nextInt();
        scanner.nextLine();

        return new Member(nif,name,surname,zipCode);
    }
}
