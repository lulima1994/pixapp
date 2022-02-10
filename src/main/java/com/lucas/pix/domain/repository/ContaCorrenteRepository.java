package com.lucas.pix.domain.repository;

import com.lucas.pix.domain.model.ContaCorrente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Long> {
    @Query("select cc from ContaCorrente cc where cc.agencia=:agencia and cc.conta=:conta and cc.banco.codigo=:codigo")
    Optional<ContaCorrente> findByAccount(Integer agencia, Integer conta, String codigo);

    @Query("select cc from ContaCorrente cc join Chave c on c.contaCorrente.id = cc.id where c.valor=:valor")
    Optional<ContaCorrente> findByKey(String valor);
}
