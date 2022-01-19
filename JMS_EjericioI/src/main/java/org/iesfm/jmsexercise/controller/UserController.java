package org.iesfm.jmsexercise.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @RequestMapping(method = RequestMethod.POST, path = "/users")
    public  void createUser(@RequestBody User user){

}
}
