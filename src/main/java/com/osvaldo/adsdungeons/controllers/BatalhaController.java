package com.osvaldo.adsdungeons.controllers;

import com.osvaldo.adsdungeons.domain.Batalha;
import com.osvaldo.adsdungeons.repositories.BatalhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class BatalhaController {

    @Autowired
    BatalhaRepository batalhaRepository;

    @GetMapping("/batalhas")
    public ResponseEntity<List<Batalha>> getBatalhas(){
        List<Batalha> batalhas = batalhaRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(batalhas);
    }

    @GetMapping("/batalha/{id}")
    public ResponseEntity<Batalha> getOneBatalha(@PathVariable(value = "id") UUID id) {
        Optional<Batalha> batalha = batalhaRepository.findById(id);
        if (batalha.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(batalha.get());
    }


}
