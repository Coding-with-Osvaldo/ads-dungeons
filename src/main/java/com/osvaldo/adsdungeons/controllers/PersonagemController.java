package com.osvaldo.adsdungeons.controllers;

import com.osvaldo.adsdungeons.repositories.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonagemController {

    @Autowired
    PersonagemRepository personagemRepository;

    @GetMapping("/personagens")
    public ResponseEntity<List<Object>> getInimigos(){
        List<Object> result = personagemRepository.findAllClass();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
