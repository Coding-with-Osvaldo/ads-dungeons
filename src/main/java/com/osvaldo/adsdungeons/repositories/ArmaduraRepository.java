package com.osvaldo.adsdungeons.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
import com.osvaldo.adsdungeons.domain.Armadura;

public interface ArmaduraRepository extends JpaRepository<Armadura, UUID> {



}
