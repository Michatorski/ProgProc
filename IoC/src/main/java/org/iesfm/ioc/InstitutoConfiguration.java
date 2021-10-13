package org.iesfm.ioc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InstitutoConfiguration {
    @Bean
    public InstitutoPrograma institutoPrograma(
            InstitutoFileScanner institutoFileScanner,
            InstitutoWriter writer,
            InstitutoReader reader
    ) {
        return new InstitutoPrograma(institutoFileScanner, reader, writer);
    }

    @Bean
    public InstitutoFileScanner institutoFileScanner() {
        return new InstitutoFileScanner();
    }


    @Bean
    public InstitutoWriter institutoWriter() {
        return new InstitutoWriter();
    }

    @Bean
    public InstitutoReader institutoReader(ObjectMapper objectMapper) {
        return new InstitutoReader(objectMapper);
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
