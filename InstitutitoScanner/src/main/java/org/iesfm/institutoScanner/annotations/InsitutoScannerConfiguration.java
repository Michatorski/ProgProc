package org.iesfm.institutoScanner.annotations;

import org.iesfm.institutoScanner.GroupScannerReader;
import org.iesfm.institutoScanner.InstitutoScannerReader;
import org.iesfm.institutoScanner.ScannerUtils;
import org.iesfm.institutoScanner.StudentScannerReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class InsitutoScannerConfiguration {

    @Bean
    public InstitutoScannerReader institutoScannerReader (Scanner scanner, GroupScannerReader groupScannerReader){
        return new InstitutoScannerReader(scanner, groupScannerReader);
    }
    @Bean
    public ScannerUtils scannerUtils (Scanner scanner){
        return new ScannerUtils(scanner);
    }

    @Bean
    public GroupScannerReader groupScannerReader(Scanner scanner, StudentScannerReader studentScannerReader){
        return new GroupScannerReader(scanner, studentScannerReader);
    }

   @Bean
    public StudentScannerReader studentScannerReader (Scanner scanner){
       return new StudentScannerReader(scanner);
   }

   @Bean
    public  Scanner scanner(){
       return new Scanner(System.in);
   }
}
