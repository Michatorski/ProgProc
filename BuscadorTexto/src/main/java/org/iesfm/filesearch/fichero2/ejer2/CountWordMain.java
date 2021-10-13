package org.iesfm.filesearch.fichero2.ejer2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Scanner;

public class CountWordMain {
    public static Logger log = LoggerFactory.getLogger(CountWordMain.class);

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        log.info("Introduce un directorio");
        String folderPath = scan.nextLine();

        log.info("Introduce la palabra a buscar: ");
        String word = scan.nextLine();

        File folder = new File(folderPath);

        File[] files = folder.listFiles();
        int occurences = 0;
        for (File file : files) {
            CountWordTask countWordTask = new CountWordTask(file,word);
            Thread countWordThread = new Thread(countWordTask);
            countWordThread.start();

            try {
                countWordThread.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            occurences += countWordTask.getOccurences();
        }

        log.info("La palabra " + word + " aparece " + occurences);
    }
}
