package com.lucas.pix.domain.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Chave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 90)
    private String valor;
    @ManyToOne
    @JoinColumn(name = "conta_corrente_id")
    private ContaCorrente contaCorrente;
    @ManyToOne
    @JoinColumn(name = "tipo_chave_id")
    private TipoChave tipoChave;
}
