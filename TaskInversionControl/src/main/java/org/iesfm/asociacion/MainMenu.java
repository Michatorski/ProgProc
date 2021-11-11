package org.iesfm.asociacion;

import org.iesfm.asociacion.program.MemberProgram;
import org.iesfm.asociacion.reader.MemberReader;
import org.iesfm.asociacion.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class MainMenu {
    private final static Logger log = LoggerFactory.getLogger(MainMenu.class);
    private Scanner scan;

    private MemberProgram program;

    public MainMenu(Scanner scan, MemberProgram program) {
        this.scan = scan;
        this.program = program;
    }

    public void executeMenu() {
        boolean salir = false;
        while (!salir) {
            log.info("Bienvenido. Escoge la opicion que quiere realizar.");
            log.info("1. Listar Socio.");
            log.info("2. Añadir Socio.");
            log.info("3. Eliminar Socio segun nif.");
            log.info("4. Modificar Socio.");
            log.info("5. Salir.");

            int option = scan.nextInt();
            scan.nextLine();

            switch (option) {
                case 1:
                    program.list();
                    break;
                case 2:
                    program.insert();
                    break;
                case 3:
                    log.info("Introduce un nif ya registrado");
                    program.delete(scan.nextLine());
                    break;
                case 4:
                    program.modify();
                    break;
                case 5:
                    salir = true;
                    break;
            }
        }
    }
}
