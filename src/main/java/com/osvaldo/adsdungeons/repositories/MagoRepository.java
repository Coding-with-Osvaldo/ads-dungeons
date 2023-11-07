package com.osvaldo.adsdungeons.repositories;

import com.osvaldo.adsdungeons.domain.Mago;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MagoRepository extends JpaRepository<Mago, UUID> {
}
