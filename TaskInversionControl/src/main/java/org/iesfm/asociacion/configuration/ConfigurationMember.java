package org.iesfm.asociacion.configuration;

import org.iesfm.asociacion.MainMenu;
import org.iesfm.asociacion.program.MemberProgram;
import org.iesfm.asociacion.reader.MemberReader;
import org.iesfm.asociacion.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class ConfigurationMember {

    @Bean
    public MainMenu mainMenu(MemberProgram program, Scanner scanner){
        return new MainMenu( scanner, program);
    }

    @Bean
    public MemberProgram memberProgram(MemberReader reader, MemberService service){
        return  new MemberProgram( reader, service);
    }

    @Bean
    public MemberReader memberReader(Scanner scanner){
        return new MemberReader(scanner);
    }

    @Bean
    public MemberService memberService(){
        return new MemberService();
    }
    @Bean
    public Scanner scanner(){
        return new Scanner(System.in);
    }
}
