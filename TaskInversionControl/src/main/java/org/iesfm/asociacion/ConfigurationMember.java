package org.iesfm.asociacion;

import org.iesfm.asociacion.MainMenu;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationMember {

    @Bean
    public MainMenu mainMenu(){
        return mainMenu();
    }
}
