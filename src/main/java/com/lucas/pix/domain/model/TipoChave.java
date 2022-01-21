package com.lucas.pix.domain.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class TipoChave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 45)
    private String nome;
    @OneToMany(mappedBy = "tipoChave")
    private Chave chave;
}
