package org.iesfm.shop.listener.email;

import org.iesfm.shop.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;

public class EmailListener {

    private final static Logger log = LoggerFactory.getLogger(EmailListener.class);

    @JmsListener(destination = "shop_emails")
    public void onMessage(Email email) {
        log.info(
                "Enviando email " + email.toString()
        );
    }

}
