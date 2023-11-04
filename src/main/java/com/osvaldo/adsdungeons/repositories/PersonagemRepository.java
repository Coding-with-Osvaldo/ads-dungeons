package com.osvaldo.adsdungeons.repositories;

import com.osvaldo.adsdungeons.domain.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PersonagemRepository extends JpaRepository<Personagem, UUID> {
    @Query(value = "select id, nome, type from Guerreiro union select id, nome,type from Atirador union select id, nome, type from Invocador union select id, nome, type from Mago", nativeQuery = true)
    List<Personagem> findAllClass();
}
