package org.iesfm.filesearch.readerText;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaskReader implements Runnable{

    public static Logger log = LoggerFactory.getLogger(TaskReader.class);

    private String text;


    public TaskReader(String text) {
        this.text = text;
    }


    @Override
    public void run() {
       log.info("Numero de texto encontrado: " + Finder.findtext(text));
    }
}
