package com.osvaldo.adsdungeons.controllers;

import com.osvaldo.adsdungeons.domain.Guerreiro;
import com.osvaldo.adsdungeons.domain.Guerreiro;
import com.osvaldo.adsdungeons.dtos.GuerreiroDTO;
import com.osvaldo.adsdungeons.dtos.HPDTO;
import com.osvaldo.adsdungeons.repositories.GuerreiroRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.UUID;

@RestController
public class GuerreiroController {

    @Autowired
    GuerreiroRepository guerreiroRepository;

    @GetMapping("/guerreiro/{id}")
    public ResponseEntity<Guerreiro> getOneGuerreiro(@PathVariable(value = "id") UUID id){
        Optional<Guerreiro> guerreiro = guerreiroRepository.findById(id);
        if (guerreiro.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(guerreiro.get());
    }

    @PostMapping("/guerreiro")
    public ResponseEntity<Guerreiro> saveGuerreiro(@RequestBody @Valid GuerreiroDTO guerreiroDTO){
        var guerreiro = new Guerreiro();
        BeanUtils.copyProperties(guerreiroDTO, guerreiro);
        return ResponseEntity.status(HttpStatus.CREATED).body(guerreiroRepository.save(guerreiro));
    }
    //https://www.baeldung.com/spring-data-partial-update
    @PatchMapping("/guerreiro/{id}")
    public ResponseEntity<Guerreiro> updateGuerreiroHP(@RequestBody @Valid HPDTO hpDTO, @PathVariable(value = "id") UUID id){
        var guerreiro = new Guerreiro();
        Optional<Guerreiro> guerreiroO = guerreiroRepository.findById(id);
        if (guerreiroO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        guerreiro = guerreiroO.get();
        guerreiro.setVida(hpDTO.vida());
        return ResponseEntity.status(HttpStatus.CREATED).body(guerreiroRepository.save(guerreiro));
    }

    @DeleteMapping("/guerreiro/{id}")
    public ResponseEntity<Object> deleteMinion(@PathVariable(value = "id") UUID id){
        Optional<Guerreiro> guerreiroO = guerreiroRepository.findById(id);
        if (guerreiroO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        guerreiroRepository.delete(guerreiroO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Guerreiro deleted successfully");
    }

}
