package com.patrinav.viewit.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movies")
public class MoviesController {
    @GetMapping
    public ResponseEntity<String> getMessage() {
        return new ResponseEntity<String>("Hola enfermera de Spring", HttpStatus.OK);
    }
}
