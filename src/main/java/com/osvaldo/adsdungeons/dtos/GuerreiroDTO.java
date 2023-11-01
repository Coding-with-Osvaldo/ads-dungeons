package com.osvaldo.adsdungeons.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record GuerreiroDTO(@NotBlank String nome, @NotNull Integer vida, @NotNull Character type, @NotNull Float forca) {}
