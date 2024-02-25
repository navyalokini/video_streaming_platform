package com.example.to_do_app.controllers;

import com.example.to_do_app.models.User;
import com.example.to_do_app.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Optional;

import static ch.qos.logback.core.joran.spi.ConsoleTarget.findByName;


@RestController
@CrossOrigin("http://localhost:5173")
public class UserControllers {

@Autowired
private UserRepository userRepository;
@PostMapping("/register-user")
public ResponseEntity<?>registerUser(@Valid @RequestBody User user, BindingResult resultset){


    if(resultset.hasErrors()){
        HashMap<String,String> errorMap= new HashMap<>();
        for (FieldError error: resultset.getFieldErrors()){
            var field=error.getField();
            var defaultMessage=error.getDefaultMessage();
            errorMap.put(field,defaultMessage);
        }
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }

    var savedUser=userRepository.save(user);
    return new ResponseEntity<>(savedUser,HttpStatus.ACCEPTED);

}



@PostMapping("/login")

    public ResponseEntity<?> attemptLogin(@RequestBody User user){
    var username= user.getUsername();
    var password=user.getPassword();

   Optional<User> optionalUser=userRepository.findByUsername(username);
   HashMap<String,String> responseMap= new HashMap<>();
   if(optionalUser.isPresent()){
       var dbPassword=optionalUser.get().getPassword();
       if(password.equals(dbPassword)){
           responseMap.put("isAuthenticated","true");
           responseMap.put("userId",optionalUser.get().getId()+"");
           return new ResponseEntity<>(responseMap,HttpStatus.ACCEPTED);
       } else {
           responseMap.put("isAuthenticated","false");
           responseMap.put("reason","INCORRECT_PASSWORD");
           return new ResponseEntity<>(responseMap,HttpStatus.ACCEPTED);
       }

   }
   else{
       responseMap.put("isAuthenticated","false");
       responseMap.put("reason","INVALID_USERNAME");
       return new ResponseEntity<>(responseMap,HttpStatus.ACCEPTED);
   }



}

}
