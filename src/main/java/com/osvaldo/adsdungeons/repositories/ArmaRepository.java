package com.osvaldo.adsdungeons.repositories;

import com.osvaldo.adsdungeons.domain.Arma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ArmaRepository extends JpaRepository<Arma, UUID> {
}
