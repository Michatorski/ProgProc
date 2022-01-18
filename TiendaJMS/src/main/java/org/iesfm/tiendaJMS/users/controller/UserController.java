package org.iesfm.tiendaJMS.users.controller;

import org.iesfm.tiendaJMS.users.User;
import org.iesfm.tiendaJMS.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

  @RequestMapping(method = RequestMethod.POST, path = "/users")
    public void insertUser(@RequestBody User user){
      if (userRepository.existsById(user.getEmail())){
          throw new ResponseStatusException(
                  HttpStatus.CONFLICT,
                  "Ya existe un cliente con este Email " + user.getEmail()
          );
      } else {
          userRepository.save(user);
      }
  }

}
