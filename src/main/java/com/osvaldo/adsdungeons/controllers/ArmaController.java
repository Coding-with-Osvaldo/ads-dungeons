package com.osvaldo.adsdungeons.controllers;

import com.osvaldo.adsdungeons.domain.Arma;
import com.osvaldo.adsdungeons.dtos.ArmaDTO;
import com.osvaldo.adsdungeons.repositories.ArmaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ArmaController {

    @Autowired
    ArmaRepository armaRepository;

    @GetMapping("/armas")
    public ResponseEntity<List<Arma>> getArmas(){
        List<Arma> arma = armaRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(arma);
    }

    @GetMapping("/arma/{id}")
    public ResponseEntity<Arma> getOneArma(@PathVariable(value = "id") UUID id) {
        Optional<Arma> arma = armaRepository.findById(id);
        if (arma.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(arma.get());
    }

    @PostMapping("/arma")
    public ResponseEntity<Arma> saveArma(@RequestBody @Valid ArmaDTO armaDTO){
        var arma = new Arma();
        BeanUtils.copyProperties(armaDTO, arma);
        return ResponseEntity.status(HttpStatus.CREATED).body(armaRepository.save(arma));
    }

    @DeleteMapping("/arma/{id}")
    public ResponseEntity<Object> deleteArma(@PathVariable(value = "id") UUID id){
        Optional<Arma> armaO = armaRepository.findById(id);
        if (armaO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Arma not found");
        }
        armaRepository.delete(armaO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Arma deleted successfully");
    }

}
