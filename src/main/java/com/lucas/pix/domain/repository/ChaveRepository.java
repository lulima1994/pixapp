package com.lucas.pix.domain.repository;

import com.lucas.pix.domain.model.Chave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChaveRepository extends JpaRepository<Chave, Long> {
}
