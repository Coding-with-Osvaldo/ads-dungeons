package com.osvaldo.adsdungeons.dtos;

import com.osvaldo.adsdungeons.domain.Personagem;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record UsuarioDTO(@NotBlank String nome) {
}
