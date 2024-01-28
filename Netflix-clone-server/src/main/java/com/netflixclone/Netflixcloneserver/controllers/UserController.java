package com.netflixclone.Netflixcloneserver.controllers;


import com.netflixclone.Netflixcloneserver.models.User;
import com.netflixclone.Netflixcloneserver.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @PostMapping("/register-user")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user, BindingResult result){
      if(result.hasErrors()){
          HashMap<String,String> errorMap= new HashMap<>();
          for(FieldError error:result.getFieldErrors()){
              var field=error.getField();
              var defaultMessage=error.getDefaultMessage();
              errorMap.put(field,defaultMessage);
          }
          return new ResponseEntity<>(errorMap, HttpStatus.OK);
      }
      var savedUser = userRepository.save(user);
      return new ResponseEntity<>(savedUser, HttpStatusCode.valueOf(200));
  }




}
