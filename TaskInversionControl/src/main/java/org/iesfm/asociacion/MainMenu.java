package org.iesfm.asociacion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class MainMenu {
    private final static Logger log = LoggerFactory.getLogger(MainMenu.class);
    private Scanner scan;
    private Member member;

    public MainMenu(Scanner scan, Member member) {
        this.scan = scan;
        this.member = member;
    }

    public void mainMenu() {
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
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    salir = true;
                    break;
            }
        }
    }
}
