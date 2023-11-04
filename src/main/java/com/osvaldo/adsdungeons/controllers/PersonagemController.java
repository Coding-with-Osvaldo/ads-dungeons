package com.osvaldo.adsdungeons.controllers;

import com.osvaldo.adsdungeons.domain.Inimigo;
import com.osvaldo.adsdungeons.domain.Personagem;
import com.osvaldo.adsdungeons.dtos.InimigoDTO;
import com.osvaldo.adsdungeons.repositories.InimigosRepository;
import com.osvaldo.adsdungeons.repositories.PersonagemRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonagemController {

    @Autowired
    PersonagemRepository personagemRepository;

    @GetMapping("/personagens")
    public ResponseEntity<List<Personagem>> getInimigos(){
        List<Personagem> result = personagemRepository.findAllClass();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
