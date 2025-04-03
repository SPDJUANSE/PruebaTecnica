package com.example.practico2.controllers;

import com.example.practico2.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class MainController {

    private final MainService service;

    @Autowired
    public  MainController(MainService service){
        this.service = service;
    }

    @GetMapping("/consultarPasiente")
    public ResponseEntity<?> consultarPasiente(){
        try {
            return ResponseEntity.ok(service.readPatientInformation());
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
