package com.osvaldo.adsdungeons.dtos;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record PartyMemberDTO(@NotNull UUID id, Integer vida,Integer municao, Integer mana, @NotNull Character type) {
}
