package com.osvaldo.adsdungeons.dtos;

import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public record BatalhaDTO(@NotNull List<UUID> inimigos) {
}
