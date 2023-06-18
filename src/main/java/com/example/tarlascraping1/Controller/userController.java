package com.example.tarlascraping1.Controller;

import com.example.tarlascraping1.ModelsDTO.userDto;
import com.example.tarlascraping1.Services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth/")
public class userController {
    @Autowired
    private userService userservice;

    @PostMapping("signup")
    public ResponseEntity login(@RequestBody userDto userdto){
        return new ResponseEntity(userservice.saveUser(userdto), HttpStatus.OK);
    }

    @PostMapping("signin")
    public ResponseEntity signin(@RequestBody userDto userdto){
        return new ResponseEntity(userservice, HttpStatus.OK);
    }



}
