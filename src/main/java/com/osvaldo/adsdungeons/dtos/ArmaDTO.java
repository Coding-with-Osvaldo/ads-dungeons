package com.osvaldo.adsdungeons.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ArmaDTO(@NotBlank String nome, @NotBlank String atributo, @NotBlank String descricao, @NotNull Integer dano) {
}
