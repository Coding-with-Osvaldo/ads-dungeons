package com.osvaldo.adsdungeons.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record AtiradorDTO(@NotNull UUID id, @NotBlank String nome, @NotNull Integer vida, Integer municao) {
}
