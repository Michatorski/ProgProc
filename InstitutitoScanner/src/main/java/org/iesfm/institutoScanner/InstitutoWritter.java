package org.iesfm.institutoScanner;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.iesfm.institutoScanner.reader.InstitutoScannerReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class InstitutoWritter {
    private final static Logger log = LoggerFactory.getLogger(InstitutoWritter.class);

    private ObjectMapper mapper;

    private  String path;

    public InstitutoWritter(ObjectMapper mapper, String path) {
        this.mapper = mapper;
        this.path = path;
    }

    public void writeInstituto (Instituto instituto){
        try {
            mapper.writeValue(
                    new FileOutputStream(new File(
                            path)),
                    instituto
            );
        } catch (JsonMappingException e){
            log.error("El json no esta bien formado", e);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
