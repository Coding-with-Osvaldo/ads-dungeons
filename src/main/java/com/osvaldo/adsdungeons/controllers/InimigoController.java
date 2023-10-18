package com.osvaldo.adsdungeons.controllers;

import com.osvaldo.adsdungeons.domain.Inimigo;
import com.osvaldo.adsdungeons.dtos.InimigoDTO;
import com.osvaldo.adsdungeons.repositories.InimigosRepository;
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
public class InimigoController {

    @Autowired
    InimigosRepository inimigosRepository;

    @GetMapping("/inimigos")
    public ResponseEntity<List<Inimigo>> getInimigos(){
        List<Inimigo> result = inimigosRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/inimigo")
    public ResponseEntity<Inimigo> saveInimigo(@RequestBody @Valid InimigoDTO inimigoDTO) {
        var inimigoModel = new Inimigo();
        BeanUtils.copyProperties(inimigoDTO, inimigoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(inimigosRepository.save(inimigoModel));
    }
}
