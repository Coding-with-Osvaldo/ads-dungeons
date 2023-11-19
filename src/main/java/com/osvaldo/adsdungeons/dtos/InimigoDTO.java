package com.osvaldo.adsdungeons.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InimigoDTO(@NotBlank String nome, @NotNull Integer dano, @NotNull Float vida) {
}
