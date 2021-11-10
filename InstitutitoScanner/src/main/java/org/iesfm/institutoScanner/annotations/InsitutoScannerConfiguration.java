package org.iesfm.institutoScanner.annotations;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.iesfm.institutoScanner.InstitutoReadAndWrite;
import org.iesfm.institutoScanner.InstitutoWritter;
import org.iesfm.institutoScanner.reader.GroupScannerReader;
import org.iesfm.institutoScanner.reader.InstitutoScannerReader;
import org.iesfm.institutoScanner.ScannerUtils;
import org.iesfm.institutoScanner.reader.StudentScannerReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Scanner;

@Configuration
@PropertySource("application.properties")
public class InsitutoScannerConfiguration {

    @Bean
    public ObjectMapper mapper(){
        return new ObjectMapper();
    }

    @Bean
    public InstitutoReadAndWrite institutoReadAndWrite
            (InstitutoScannerReader institutoScannerReader,
             InstitutoWritter institutoWritter){
        return new InstitutoReadAndWrite (institutoScannerReader, institutoWritter);
    }

    @Bean
    public InstitutoWritter institutoWritter(
            ObjectMapper mapper,
            @Value("instituto.path") String path
    ){
        return institutoWritter(mapper, path);
    }

    @Bean
    public InstitutoScannerReader institutoScannerReader (Scanner scanner, GroupScannerReader groupScannerReader, ScannerUtils scannerUtils){
        return new InstitutoScannerReader(scanner, groupScannerReader, scannerUtils);
    }
    @Bean
    public ScannerUtils scannerUtils (Scanner scanner){
        return new ScannerUtils(scanner);
    }

    @Bean
    public GroupScannerReader groupScannerReader(Scanner scanner, StudentScannerReader studentScannerReader, ScannerUtils scannerUtils){
        return new GroupScannerReader(scanner, studentScannerReader, scannerUtils);
    }

   @Bean
    public StudentScannerReader studentScannerReader (Scanner scanner, ScannerUtils scannerUtils){
       return new StudentScannerReader(scanner, scannerUtils);
   }

   @Bean
    public  Scanner scanner(){
       return new Scanner(System.in);
   }
}
