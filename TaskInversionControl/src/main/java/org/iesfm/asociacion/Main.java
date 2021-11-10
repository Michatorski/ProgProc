package org.iesfm.asociacion;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class Main {
    public static void main(String[] args) {

ApplicationContext context =
        new AnnotationConfigApplicationContext(
                ConfigurationMember.class
        );

        MainMenu mainMenu = context.getBean(MainMenu.class);
        mainMenu.mainMenu();
    }
}
