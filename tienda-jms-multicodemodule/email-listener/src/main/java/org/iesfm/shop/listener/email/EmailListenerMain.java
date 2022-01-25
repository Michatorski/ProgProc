package org.iesfm.shop.listener.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmailListenerMain {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(EmailListenerMain.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
    }
}
