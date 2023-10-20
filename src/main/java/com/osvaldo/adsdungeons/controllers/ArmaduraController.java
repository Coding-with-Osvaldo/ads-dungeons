package com.osvaldo.adsdungeons.controllers;

import com.osvaldo.adsdungeons.dtos.ArmaduraDTO;
import com.osvaldo.adsdungeons.repositories.ArmaduraRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.osvaldo.adsdungeons.domain.Armadura;

import java.util.List;

@RestController
public class ArmaduraController {

    @Autowired
    ArmaduraRepository armaduraRepository;

    @GetMapping("/armaduras")
    public ResponseEntity<List<Armadura>> getArmadura() {
        List<Armadura> armadura = armaduraRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(armadura);
    }

    @PostMapping("/armadura")
    public ResponseEntity<Armadura> saveArmadura(@RequestBody @Valid ArmaduraDTO armaduraDTO){
        var armadura = new Armadura();
        BeanUtils.copyProperties(armaduraDTO, armadura);
        return ResponseEntity.status(HttpStatus.CREATED).body(armaduraRepository.save(armadura));
    }

}
