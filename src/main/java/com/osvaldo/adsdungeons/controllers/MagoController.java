package com.osvaldo.adsdungeons.controllers;

import com.osvaldo.adsdungeons.domain.Mago;
import com.osvaldo.adsdungeons.dtos.HPDTO;
import com.osvaldo.adsdungeons.dtos.MagoDTO;
import com.osvaldo.adsdungeons.repositories.MagoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.UUID;

@RestController
public class MagoController {

    @Autowired
    MagoRepository magoRepository;

    @GetMapping("/mago/{id}")
    public ResponseEntity<Mago> getOneMago(@PathVariable(value = "id") UUID id){
        Optional<Mago> mago = magoRepository.findById(id);
        if (mago.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(mago.get());
    }

    @PostMapping("/mago")
    public ResponseEntity<Mago> saveMago(@RequestBody @Valid MagoDTO magoDTO){
        var mago = new Mago();
        BeanUtils.copyProperties(magoDTO, mago);
        return ResponseEntity.status(HttpStatus.CREATED).body(magoRepository.save(mago));
    }

    @PatchMapping("/mago/{id}")
    public ResponseEntity<Mago> updateMagoHP(@RequestBody @Valid HPDTO hpDTO, @PathVariable(value = "id") UUID id){
        var mago = new Mago();
        Optional<Mago> magoO = magoRepository.findById(id);
        if (magoO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        mago = magoO.get();
        mago.setVida(hpDTO.vida());
        return ResponseEntity.status(HttpStatus.CREATED).body(magoRepository.save(mago));
    }

    @DeleteMapping("/mago/{id}")
    public ResponseEntity<Object> deleteMinion(@PathVariable(value = "id") UUID id){
        Optional<Mago> magoO = magoRepository.findById(id);
        if (magoO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        magoRepository.delete(magoO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Mago deleted successfully");
    }

}
