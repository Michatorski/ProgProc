package org.iesfm.filesearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Scanner;

public class BufferedReaderExample {
    private static Logger log = LoggerFactory.getLogger(BufferedReaderExample.class);

    public static Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {
        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(
                                     "src/main/resources/el_quijote.txt"
                             )
                     )
        ) {
            String line = reader.readLine();

            while (line !=null){
                log.info(line);
               line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
