package com.osvaldo.adsdungeons.controllers;

import com.osvaldo.adsdungeons.domain.Feitico;
import com.osvaldo.adsdungeons.dtos.FeiticoDTO;
import com.osvaldo.adsdungeons.repositories.FeiticoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class FeiticoController {

    @Autowired
    FeiticoRepository feiticoRepository;

    @GetMapping("/feiticos")
    public ResponseEntity<List<Feitico>> getFeitico(){
        List<Feitico> feitico = feiticoRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(feitico);
    }

    @GetMapping("/feitico/{id}")
    public ResponseEntity<Feitico> getOneFeitico(@PathVariable(value = "id") UUID id){
        Optional<Feitico> feitico = feiticoRepository.findById(id);
        if (feitico.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(feitico.get());
    }

    @PostMapping("/feitico")
    public ResponseEntity<Feitico> saveFeitico(@RequestBody @Valid FeiticoDTO feiticoDTO){
        var feitico = new Feitico();
        BeanUtils.copyProperties(feiticoDTO, feitico);
        return ResponseEntity.status(HttpStatus.CREATED).body(feiticoRepository.save(feitico));
    }

    @DeleteMapping("/feitico/{id}")
    public ResponseEntity<Object> deleteFeitico(@PathVariable(value = "id") UUID id){
        Optional<Feitico> feiticoO = feiticoRepository.findById(id);
        if (feiticoO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Feitico not found");
        }

        feiticoRepository.delete(feiticoO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Feitico deleted successfully");
    }

}
