package com.osvaldo.adsdungeons.repositories;

import com.osvaldo.adsdungeons.domain.Atirador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AtiradorRepository extends JpaRepository<Atirador, UUID> {
}
