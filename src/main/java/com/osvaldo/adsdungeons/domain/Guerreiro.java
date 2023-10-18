package com.osvaldo.adsdungeons.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Guerreiro extends Personagem implements Serializable {
    private Float forca;

    @OneToOne
    Arma arma;
}
