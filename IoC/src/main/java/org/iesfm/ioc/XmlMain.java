package org.iesfm.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlMain {

    public static void main(String[] args)  {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("instituto-app.xml");
        InstitutoPrograma programa = context.getBean(InstitutoPrograma.class);
        programa.ejecutar();
    }
}
