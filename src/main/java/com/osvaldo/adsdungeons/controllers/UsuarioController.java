package com.osvaldo.adsdungeons.controllers;

import com.osvaldo.adsdungeons.domain.*;
import com.osvaldo.adsdungeons.dtos.BasicPersonagemDTO;
import com.osvaldo.adsdungeons.dtos.PartyDTO;
import com.osvaldo.adsdungeons.dtos.UsuarioDTO;
import com.osvaldo.adsdungeons.repositories.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private GuerreiroRepository guerreiroRepository;

    @Autowired
    private AtiradorRepository  atiradorRepository;

    @Autowired
    private SacerdoteRepository sacerdoteRepository;

    @Autowired
    private MagoRepository magoRepository;

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> getAllUsuario() {
        List<Usuario> result = usuarioRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario> getOneUsuario(@PathVariable(value = "id") UUID id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(usuario.get());
    }

    @PostMapping("/usuario")
    public ResponseEntity<Usuario> saveUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO){
        var usuario = new Usuario();
        List<Personagem> list = new ArrayList<>();
        for(var item : usuarioDTO.personagens()){
            switch (item.type()){
                case 'G':
                    var guerreiro = new Guerreiro();
                    guerreiro.setNome(item.nome());
                    list.add(guerreiro);
                    break;
                case 'S':
                    var sacerdote = new Sacerdote();
                    sacerdote.setNome(item.nome());
                    list.add(sacerdote);
                    break;
                case 'A':
                    var atirador = new Atirador();
                    atirador.setNome(item.nome());
                    list.add(atirador);
                    break;
                case 'M':
                    var mago = new Mago();
                    mago.setNome(item.nome());
                    list.add(mago);
                    break;
            }
        }
        usuario.setNome(usuarioDTO.nome());
        usuario.setPersonagens(list);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
    }

    @PatchMapping("/add-character/{id}")
    public ResponseEntity<Usuario> addCharacter(@RequestBody @Valid BasicPersonagemDTO basicPersonagemDTO, @PathVariable(value = "id") UUID id){
        Optional<Usuario> usuarioO = usuarioRepository.findById(id);
        if (usuarioO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        var usuario = usuarioO.get();
        List<Personagem> list = usuario.getPersonagens();
        Personagem personagem = null;
        switch (basicPersonagemDTO.type()){
            case 'G':
                personagem = new Guerreiro();
                break;
            case 'S':
                personagem = new Sacerdote();
                break;
            case 'A':
                personagem = new Atirador();
                break;
            case 'M':
                personagem = new Mago();
                break;
        }
        try {
            if (personagem == null) throw new Exception();
            personagem.setNome(basicPersonagemDTO.nome());
            list.add(personagem);

            usuario.setPersonagens(list);

            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

    @PutMapping("/update-score/{id}")
    public ResponseEntity<Usuario> updateScore(@PathVariable(value = "id") UUID id){
        Optional<Usuario> usuarioO = usuarioRepository.findById(id);
        if (usuarioO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        var usuario = usuarioO.get();
        usuario.setScore(usuario.getScore() + 1);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.save(usuario));
    }

    @PutMapping("/update-party")
    public ResponseEntity<List<Personagem>> updateParty(@RequestBody @Valid PartyDTO party){
        List<Personagem> personagens= new ArrayList<>();
        for (var personagem: party.personagens()) {
            switch (personagem.type()){
                case 'G':
                    if(!Objects.isNull(personagem.vida())){
                        var guerreiro = guerreiroRepository.findById(personagem.id()).get();
                        guerreiro.setVida(personagem.vida());
                        guerreiroRepository.save(guerreiro);
                        personagens.add(guerreiro);
                    }
                    break;

                case 'A':
                    if(!Objects.isNull(personagem.vida())){
                        var atirador = atiradorRepository.findById(personagem.id()).get();
                        atirador.setVida(personagem.vida());
                        atiradorRepository.save(atirador);
                        personagens.add(atirador);
                    }
                    if(!Objects.isNull(personagem.municao())){
                        var atirador = atiradorRepository.findById(personagem.id()).get();
                        atirador.setMunicao(personagem.municao());
                        atiradorRepository.save(atirador);
                        personagens.add(atirador);
                    }
                    break;
                case 'S':
                    if(!Objects.isNull(personagem.vida())){
                        var sacerdote = sacerdoteRepository.findById(personagem.id()).get();
                        sacerdote.setVida(personagem.vida());
                        sacerdoteRepository.save(sacerdote);
                        personagens.add(sacerdote);
                    }
                    if(!Objects.isNull(personagem.mana())){
                        var sacerdote = sacerdoteRepository.findById(personagem.id()).get();
                        sacerdote.setMana(personagem.mana());
                        sacerdoteRepository.save(sacerdote);
                        personagens.add(sacerdote);
                    }
                    break;

                case 'M':
                    if(!Objects.isNull(personagem.vida())){
                        var mago = magoRepository.findById(personagem.id()).get();
                        mago.setVida(personagem.vida());
                        magoRepository.save(mago);
                        personagens.add(mago);
                    }
                    if(!Objects.isNull(personagem.mana())){
                        var mago = magoRepository.findById(personagem.id()).get();
                        mago.setMana(personagem.mana());
                        magoRepository.save(mago);
                        personagens.add(mago);
                    }
                    break;
            }
        }

        return ResponseEntity.status(HttpStatus.OK).body(personagens);
    }

}
