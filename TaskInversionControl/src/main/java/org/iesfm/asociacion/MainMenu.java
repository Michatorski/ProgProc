package org.iesfm.asociacion;

import org.iesfm.asociacion.reader.MemberReader;
import org.iesfm.asociacion.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class MainMenu {
    private final static Logger log = LoggerFactory.getLogger(MainMenu.class);
    private Scanner scan;
    private Member member;
    private MemberService memberService;
    private MemberReader memberReader;

    public MainMenu(Scanner scan, Member member, MemberService memberService, MemberReader memberReader) {
        this.scan = scan;
        this.member = member;
        this.memberService = memberService;
        this.memberReader = memberReader;
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
                    memberService.insert(memberReader.readMemmber());
                    break;
                case 2:
                    memberService.list();
                    break;
                case 3:
                    memberService.delete(member.getNif());
                    break;
                case 4:
                    memberService.modify(member);
                    break;
                case 5:
                    salir = true;
                    break;
            }
        }
    }
}
