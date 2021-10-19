package org.iesfm.institutoScanner.annotations;

import org.iesfm.institutoScanner.StudentReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class InsitutoScannerConfiguration {

   @Bean
    public StudentReader studentReader (Scanner scanner){
       return new StudentReader(scanner);
   }

   @Bean
    public  Scanner scanner(){
       return new Scanner(System.in);
   }
}
