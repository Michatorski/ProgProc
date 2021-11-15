package org.iesfm.ioc.annotations;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.iesfm.ioc.InstitutoFileScanner;
import org.iesfm.ioc.InstitutoPrograma;
import org.iesfm.ioc.InstitutoReader;
import org.iesfm.ioc.InstitutoWriter;
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
