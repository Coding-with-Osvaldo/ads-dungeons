package com.osvaldo.adsdungeons.repositories;

import com.osvaldo.adsdungeons.domain.Guerreiro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GuerreiroRepository extends JpaRepository<Guerreiro, UUID> {
}
