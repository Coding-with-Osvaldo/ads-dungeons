package com.osvaldo.adsdungeons.repositories;

import com.osvaldo.adsdungeons.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
}
