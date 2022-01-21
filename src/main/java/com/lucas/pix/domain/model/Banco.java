package com.lucas.pix.domain.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Banco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 45)
    private String nome;
    @Column(nullable = false)
    private Integer codigo;
}
