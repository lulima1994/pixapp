package com.lucas.pix.domain.repository;

import com.lucas.pix.domain.model.Banco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BancoRepository extends JpaRepository<Banco, Long> {
    @Query("select b from Banco b where b.codigo=:codigo")
    Optional<Banco> findByCode(String codigo);
}
