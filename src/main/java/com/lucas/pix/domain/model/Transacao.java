package com.lucas.pix.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private BigDecimal valor;
    @Column
    private LocalDateTime dataHora;
    @ManyToOne
    @JoinColumn(name = "conta_corrente_id")
    private ContaCorrente contaCorrente;
    @ManyToOne
    @JoinColumn(name = "tipo_transacao_id")
    private TipoTransacao tipoTransacao;
}
