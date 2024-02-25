package com.example.to_do_app.controllers;


import com.example.to_do_app.models.UserData;
import com.example.to_do_app.repositories.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin

public class UserDataController {


    @Autowired
    private UserDataRepository userDataRepository;


    @PostMapping("/details")
    public ResponseEntity<?> detailsUser (@RequestBody UserData userData){

        var savedUser=userDataRepository.save(userData);
        return new ResponseEntity<>(savedUser, HttpStatusCode.valueOf(200));

    }

    @GetMapping("fetch-details/{userId}")
    public ResponseEntity<?> fetchDetailsUser(@PathVariable long userId){
        var object=userDataRepository.findAllByUserId(userId);
        return new ResponseEntity<>(object,HttpStatusCode.valueOf(200));
    }



}
