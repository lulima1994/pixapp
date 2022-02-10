package com.lucas.pix.domain.repository;

import com.lucas.pix.domain.model.TipoTransacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TipoTransacaoRespository extends JpaRepository<TipoTransacao, Long> {
    @Query("select tt from TipoTransacao tt where tt.nome = :nome")
    Optional<TipoTransacao> findByName(String nome);
}
