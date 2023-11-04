package com.osvaldo.adsdungeons.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
public abstract class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private Integer vida;
    private Character type;
    /*
    @ManyToMany
    @JoinTable(
            name = "PersonagensVsInimigos",
            joinColumns = @JoinColumn(name = "personagem_id"),
            inverseJoinColumns = @JoinColumn(name = "inimigo_id")
    )
    List<Inimigo> inimigos = new ArrayList<>();
    */
    /*
    @ManyToMany
    @JoinTable(
            name = "PersonagensVsPersonagens",
            joinColumns = @JoinColumn(name = "personagem_id"),
            inverseJoinColumns = @JoinColumn(name = "rival_id")
    )
    List<Personagem> personagems = new ArrayList<>();
     */


    @ManyToOne
    Armadura armadura;
}
