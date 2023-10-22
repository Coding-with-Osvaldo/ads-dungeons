package com.osvaldo.adsdungeons.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MinionDTO(@NotNull Float vida, @NotNull Integer dano, @NotBlank char alvo, @NotNull Integer custo) {
}
