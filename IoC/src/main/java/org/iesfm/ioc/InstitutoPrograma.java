package org.iesfm.ioc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Scanner;

public class InstitutoPrograma {
    private final static Logger log = LoggerFactory.getLogger(InstitutoPrograma.class);

    private InstitutoFileScanner institutoFileScanner;
    private InstitutoReader institutoReader;
    private InstitutoWriter institutoWriter;

    public InstitutoPrograma(InstitutoFileScanner institutoFileScanner, InstitutoReader institutoReader, InstitutoWriter institutoWriter) {
        this.institutoFileScanner = institutoFileScanner;
        this.institutoReader = institutoReader;
        this.institutoWriter = institutoWriter;
    }

    public void ejecutar() {
        File file = institutoFileScanner.getFile();
        Instituto instituto = institutoReader.leeInstituto(file);
        if(instituto == null) {
            log.error("No se ha encontrado el instituto");
        } else {
            institutoWriter.imprimeNombre(instituto);
        }
    }
}
