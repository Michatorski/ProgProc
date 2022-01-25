package org.iesfm.shop.api.controller;

import org.iesfm.shop.Email;
import org.iesfm.shop.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private static final Logger log = LoggerFactory.getLogger((UserController.class));

    private JmsTemplate jmsTemplate;

    public UserController(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/users")
    public void insertUser(@RequestBody User user) {
        log.info("registrando usuario " + user.getUsername());
        jmsTemplate.convertAndSend(
                "shop_emails",
                new Email(user.getEmail(),
                        "Bienvendio " + user.getUsername(),
                        "Gracias por regiustrate " + user.getUsername())
        );
    }

}
