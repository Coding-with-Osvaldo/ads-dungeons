package com.osvaldo.adsdungeons.controllers;

import com.osvaldo.adsdungeons.dtos.ArmaduraDTO;
import com.osvaldo.adsdungeons.repositories.ArmaduraRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.osvaldo.adsdungeons.domain.Armadura;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ArmaduraController {

    @Autowired
    ArmaduraRepository armaduraRepository;

    @GetMapping("/armaduras")
    public ResponseEntity<List<Armadura>> getArmadura() {
        List<Armadura> armadura = armaduraRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(armadura);
    }

    @GetMapping("/armadura/{id}")
    public ResponseEntity<Armadura> getOneArmadura(@PathVariable(value = "id") UUID id){
        Optional<Armadura> armadura = armaduraRepository.findById(id);
        if (armadura.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(armadura.get());
    }

    @PostMapping("/armadura")
    public ResponseEntity<Armadura> saveArmadura(@RequestBody @Valid ArmaduraDTO armaduraDTO){
        var armadura = new Armadura();
        BeanUtils.copyProperties(armaduraDTO, armadura);
        return ResponseEntity.status(HttpStatus.CREATED).body(armaduraRepository.save(armadura));
    }

    @DeleteMapping("/armadura/{id}")
    public ResponseEntity<Object> deleteArmadura(@PathVariable(value = "id")UUID id){
        Optional<Armadura> armaduraO = armaduraRepository.findById(id);
        if (armaduraO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Armadura not found");
        }

        armaduraRepository.delete(armaduraO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Armadura deleted successfully");
    }

}
