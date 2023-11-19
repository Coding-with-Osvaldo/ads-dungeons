package com.osvaldo.adsdungeons.controllers;

import com.osvaldo.adsdungeons.domain.Atirador;
import com.osvaldo.adsdungeons.domain.Atirador;
import com.osvaldo.adsdungeons.dtos.AtiradorDTO;
import com.osvaldo.adsdungeons.dtos.GuerreiroDTO;
import com.osvaldo.adsdungeons.dtos.HPDTO;
import com.osvaldo.adsdungeons.dtos.PersonagemDTO;
import com.osvaldo.adsdungeons.repositories.AtiradorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.UUID;

@RestController
public class AtiradorController {

    @Autowired
    AtiradorRepository atiradorRepository;

    @GetMapping("/atirador/{id}")
    public ResponseEntity<Atirador> getOneAtirador(@PathVariable(value = "id") UUID id){
        Optional<Atirador> atirador = atiradorRepository.findById(id);
        if (atirador.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(atirador.get());
    }

    @PostMapping("/atirador")
    public ResponseEntity<Atirador> saveAtirador(@RequestBody @Valid PersonagemDTO atiradorDTO){
        var atirador = new Atirador();
        BeanUtils.copyProperties(atiradorDTO, atirador);
        return ResponseEntity.status(HttpStatus.CREATED).body(atiradorRepository.save(atirador));
    }

    @PatchMapping("/atirador/{id}")
    public ResponseEntity<Atirador> updateAtiradorHP(@RequestBody @Valid HPDTO hpDTO, @PathVariable(value = "id") UUID id){
        var atirador = new Atirador();
        Optional<Atirador> atiradorO = atiradorRepository.findById(id);
        if (atiradorO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        atirador = atiradorO.get();
        atirador.setVida(hpDTO.vida());
        return ResponseEntity.status(HttpStatus.CREATED).body(atiradorRepository.save(atirador));
    }

    @DeleteMapping("/atirador/{id}")
    public ResponseEntity<Object> deleteAtirador(@PathVariable(value = "id") UUID id){
        Optional<Atirador> atiradorO = atiradorRepository.findById(id);
        if (atiradorO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        atiradorRepository.delete(atiradorO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Atirador deleted successfully");
    }

}
