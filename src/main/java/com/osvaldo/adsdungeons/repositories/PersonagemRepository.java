package com.osvaldo.adsdungeons.repositories;

import com.osvaldo.adsdungeons.domain.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PersonagemRepository extends JpaRepository<Personagem, UUID> {
    @Query(value = "select id, nome,vida, type  from Guerreiro union select id, nome,vida, type from Atirador union select id, nome,vida, type from Invocador union select id, nome,vida, type from Mago", nativeQuery = true)
    List<Object> findAllClass();
}
