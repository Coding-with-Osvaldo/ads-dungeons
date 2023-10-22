package com.osvaldo.adsdungeons.controllers;

import com.osvaldo.adsdungeons.domain.Armadura;
import com.osvaldo.adsdungeons.domain.Minion;
import com.osvaldo.adsdungeons.dtos.ArmaduraDTO;
import com.osvaldo.adsdungeons.dtos.MinionDTO;
import com.osvaldo.adsdungeons.repositories.MinionRepository;
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
public class MinionController {

    @Autowired
    MinionRepository minionRepository;

    @GetMapping("/minions")
    public ResponseEntity<List<Minion>> getMinion(){
        List<Minion> minion = minionRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(minion);
    }

    @GetMapping("/minion/{id}")
    public ResponseEntity<Minion> getOneMinion(@PathVariable(value = "id") UUID id){
        Optional<Minion> minion = minionRepository.findById(id);
        if (minion.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(minion.get());
    }

    @PostMapping("/minion")
    public ResponseEntity<Minion> saveMinion(@RequestBody @Valid MinionDTO minionDTO){
        var minion = new Minion();
        BeanUtils.copyProperties(minionDTO, minion);
        return ResponseEntity.status(HttpStatus.CREATED).body(minionRepository.save(minion));
    }

    @DeleteMapping("/minion/{id}")
    public ResponseEntity<Object> deleteMinion(@PathVariable(value = "id") UUID id){
        Optional<Minion> minionO = minionRepository.findById(id);
        if (minionO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        minionRepository.delete(minionO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Minion deleted successfully");
    }
}
