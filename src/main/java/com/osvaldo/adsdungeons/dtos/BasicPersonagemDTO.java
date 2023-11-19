package com.osvaldo.adsdungeons.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BasicPersonagemDTO(@NotBlank String nome, @NotNull Character type) {
}
