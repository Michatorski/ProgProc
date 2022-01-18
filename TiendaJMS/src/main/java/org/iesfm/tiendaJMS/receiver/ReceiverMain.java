package org.iesfm.tiendaJMS.receiver;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ReceiverMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext =
                SpringApplication.run(ReceiverMain.class, args);


    }
}
