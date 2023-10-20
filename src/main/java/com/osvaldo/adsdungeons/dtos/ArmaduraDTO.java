package com.osvaldo.adsdungeons.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ArmaduraDTO(@NotBlank String nome, @NotBlank String descricao, @NotNull Float defesa) {
}
