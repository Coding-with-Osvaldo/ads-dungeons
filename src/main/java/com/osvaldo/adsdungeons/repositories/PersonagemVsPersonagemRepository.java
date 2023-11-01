package com.osvaldo.adsdungeons.repositories;

import com.osvaldo.adsdungeons.domain.PersonagemVsPersonagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonagemVsPersonagemRepository extends JpaRepository<PersonagemVsPersonagem, UUID> { }
