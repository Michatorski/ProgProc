package org.iesfm.filesearch.readerText;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Finder {
    private static Logger log = LoggerFactory.getLogger(Finder.class);

    public static int findtext(String text) {

        int wordsCount = 0;

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(
                                     "src/main/resources/el_quijote.txt"
                             )
                     )
        ) {
            String line = reader.readLine();
            while (line != null) {
                if(line.contains(text)){
                    wordsCount++;
                }
                line = reader.readLine();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return wordsCount;
    }


}
