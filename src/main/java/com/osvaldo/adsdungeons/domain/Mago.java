package com.osvaldo.adsdungeons.domain;

import jakarta.persistence.*;
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
public class Mago extends Personagem implements Serializable {
    private Integer mana;

    @ManyToMany
    @JoinTable(
            name = "FEITICOS_MAGOS",
            joinColumns= @JoinColumn(name = "mago_id"),
            inverseJoinColumns = @JoinColumn(name = "feitico_name")
    )
    List<Feitico> feiticos = new ArrayList<>();
}
