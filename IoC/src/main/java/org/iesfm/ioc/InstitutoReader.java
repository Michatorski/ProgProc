package org.iesfm.ioc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class InstitutoReader {

    private final static Logger log = LoggerFactory.getLogger(InstitutoReader.class);

    private ObjectMapper objectMapper;

    public InstitutoReader(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Instituto leeInstituto(File file) {
        try {
            return objectMapper.readValue(file, Instituto.class);
        } catch (IOException e) {
            log.error("Error leyendo el instituto", e);
        }
        return null;
    }
}
