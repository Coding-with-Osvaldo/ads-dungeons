package com.osvaldo.adsdungeons.repositories;

import com.osvaldo.adsdungeons.domain.Batalha;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BatalhaRepository extends JpaRepository<Batalha, UUID> {
}
