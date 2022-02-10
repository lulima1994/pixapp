package com.lucas.pix.domain.repository;

import com.lucas.pix.domain.model.Chave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ChaveRepository extends JpaRepository<Chave, Long> {
    @Query("select c from Chave c where c.valor=:valor")
    Optional<Chave> findByName(String valor);
}
