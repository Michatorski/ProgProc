package org.iesfm.filesearch.readerText;

import org.iesfm.filesearch.BufferedReaderExample;
import org.iesfm.filesearch.taskExample.SaludoTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {
    private static Logger log = LoggerFactory.getLogger(BufferedReaderExample.class);

    public static Scanner scan = new Scanner(System.in);

    public static void startSearcher() {
        System.out.println("Introduce la palabra que busques. ");
        String text = scan.nextLine();

        while (!text.equals("exit")) {
//            log.info("Numero total de palabras encotradas: " + Finder.findtext(text));

            Thread searchTask = new Thread(new TaskReader(text));
            searchTask.start();


            log.info("Quieres seguir? ");
            text = scan.nextLine();
        }
    }

    public static void main(String[] args) {

        startSearcher();


    }
}
