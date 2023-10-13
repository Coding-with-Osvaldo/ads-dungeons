package com.osvaldo.adsdungeons.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Feitico implements Serializable {

    @Id
    private String nome;
    private Integer dano;
    private String descricao;
    private String efeito;
    private Integer custo;

    @ManyToMany(mappedBy = "feiticos")
    List<Mago> magos = new ArrayList<>();
}
