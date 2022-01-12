package org.iesfm.jms;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.connection.SingleConnectionFactory;

@Configuration
@PropertySource("applications.properties")
public class JmsConficuration {
    public SingleConnectionFactory connectionFactory(){
        SingleConnectionFactory connectionFactory
                = new SingleConnectionFactory();
    }
}
