package com.example.to_do_app.controllers;

import com.example.to_do_app.models.User;
import com.example.to_do_app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserControllers {

@Autowired
private UserRepository userRepository;
@PostMapping("/register-user")
public User registerUser(@RequestBody User user){

    return userRepository.save(user);

}



}
