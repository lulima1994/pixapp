package com.lucas.pix.domain.repository;

import com.lucas.pix.domain.model.TipoChave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TipoChaveRepository extends JpaRepository<TipoChave, Long> {
    @Query("select tc from TipoChave tc where tc.nome = :nome")
    Optional<TipoChave> findByName(String nome);
}
