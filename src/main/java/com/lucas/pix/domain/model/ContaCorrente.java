package com.lucas.pix.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
public class ContaCorrente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer agencia;
    @Column(nullable = false)
    private Integer conta;
    @Column(nullable = false)
    private BigDecimal saldo;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "banco_id")
    private Banco banco;
    @OneToMany(mappedBy = "contaCorrente")
    private List<Chave> chave;
    @OneToMany(mappedBy = "contaCorrente")
    private List<Transacao> transacao;
}
