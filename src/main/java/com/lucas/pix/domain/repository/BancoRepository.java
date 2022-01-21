package com.lucas.pix.domain.repository;

import com.lucas.pix.domain.model.Banco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BancoRepository extends JpaRepository<Banco, Long> {
}
