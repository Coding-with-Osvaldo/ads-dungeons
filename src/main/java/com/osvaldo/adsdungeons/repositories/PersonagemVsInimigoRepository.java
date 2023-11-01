package com.osvaldo.adsdungeons.repositories;

import com.osvaldo.adsdungeons.domain.PersonagemVsInimigo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonagemVsInimigoRepository extends JpaRepository<PersonagemVsInimigo, UUID> {}
