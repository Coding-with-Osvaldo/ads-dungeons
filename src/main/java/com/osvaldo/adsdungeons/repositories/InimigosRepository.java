package com.osvaldo.adsdungeons.repositories;

import com.osvaldo.adsdungeons.domain.Inimigo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InimigosRepository extends JpaRepository<Inimigo, UUID> { }
