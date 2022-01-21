package com.lucas.pix.domain.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class TipoTransacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 45)
    private String nome;
}
