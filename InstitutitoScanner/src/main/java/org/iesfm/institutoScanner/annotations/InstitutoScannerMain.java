package org.iesfm.institutoScanner.annotations;

import org.iesfm.institutoScanner.StudentReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InstitutoScannerMain {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(
                        InsitutoScannerConfiguration.class
                );
        //Sacamos el bean StudentReader del contexto de la applicaion
        StudentReader program = context.getBean(StudentReader.class);
        //Leemos
        program.readStudent();

    }
}