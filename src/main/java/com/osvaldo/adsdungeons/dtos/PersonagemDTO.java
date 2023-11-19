package com.osvaldo.adsdungeons.dtos;

import jakarta.validation.constraints.NotBlank;

public record PersonagemDTO(@NotBlank String nome) {
}
