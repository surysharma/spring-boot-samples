package com.thebigscale.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(value = "/home", produces = MediaType.ALL_VALUE)
    public ResponseEntity<?> home(){
        return new ResponseEntity<>("Hello Anoushka", HttpStatus.OK);
    }
}
