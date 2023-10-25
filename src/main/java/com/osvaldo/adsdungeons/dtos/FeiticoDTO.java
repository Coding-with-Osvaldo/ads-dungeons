package com.osvaldo.adsdungeons.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FeiticoDTO(@NotBlank String nome, @NotNull Integer dano, @NotBlank String descricao, @NotBlank String efeito, @NotNull Integer custo) {
}
