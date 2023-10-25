package com.osvaldo.adsdungeons.repositories;

import com.osvaldo.adsdungeons.domain.Feitico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FeiticoRepository extends JpaRepository<Feitico, UUID> {
}
