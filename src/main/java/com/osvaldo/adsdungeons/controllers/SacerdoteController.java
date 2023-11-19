package com.osvaldo.adsdungeons.controllers;

import com.osvaldo.adsdungeons.domain.Mago;
import com.osvaldo.adsdungeons.domain.Sacerdote;
import com.osvaldo.adsdungeons.dtos.GuerreiroDTO;
import com.osvaldo.adsdungeons.dtos.HPDTO;
import com.osvaldo.adsdungeons.dtos.PersonagemDTO;
import com.osvaldo.adsdungeons.dtos.SacerdoteDTO;
import com.osvaldo.adsdungeons.repositories.SacerdoteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.UUID;

@RestController
public class SacerdoteController {

    @Autowired
    SacerdoteRepository sacerdoteRepository;

    @GetMapping("/sacerdote/{id}")
    public ResponseEntity<Sacerdote> getOneSacerdote(@PathVariable(value = "id") UUID id){
        Optional<Sacerdote> sacerdote = sacerdoteRepository.findById(id);
        if (sacerdote.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(sacerdote.get());
    }

    @PostMapping("/sacerdote")
    public ResponseEntity<Sacerdote> saveSacerdote(@RequestBody @Valid PersonagemDTO sacerdoteDTO){
        var sacerdote = new Sacerdote();
        BeanUtils.copyProperties(sacerdoteDTO, sacerdote);
        return ResponseEntity.status(HttpStatus.CREATED).body(sacerdoteRepository.save(sacerdote));
    }

    @PatchMapping("/sacerdote/{id}")
    public ResponseEntity<Sacerdote> updateSacerdoteHP(@RequestBody @Valid HPDTO hpDTO, @PathVariable(value = "id") UUID id){
        var sacerdote = new Sacerdote();
        Optional<Sacerdote> sacerdoteO = sacerdoteRepository.findById(id);
        if (sacerdoteO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        sacerdote = sacerdoteO.get();
        sacerdote.setVida(hpDTO.vida());
        return ResponseEntity.status(HttpStatus.CREATED).body(sacerdoteRepository.save(sacerdote));
    }

    @DeleteMapping("/sacerdote/{id}")
    public ResponseEntity<Object> deleteMinion(@PathVariable(value = "id") UUID id){
        Optional<Sacerdote> sacerdoteO = sacerdoteRepository.findById(id);
        if (sacerdoteO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        sacerdoteRepository.delete(sacerdoteO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Sacerdote deleted successfully");
    }

}
