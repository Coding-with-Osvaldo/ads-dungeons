package com.osvaldo.adsdungeons.repositories;

import com.osvaldo.adsdungeons.domain.Sacerdote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SacerdoteRepository extends JpaRepository<Sacerdote, UUID> {
}
