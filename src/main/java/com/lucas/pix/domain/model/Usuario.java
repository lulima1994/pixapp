package com.lucas.pix.domain.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 45)
    private String nome;
    @Column(nullable = false, length = 90)
    private String email;
    @Column(nullable = false, length = 180)
    private String senha;
    @OneToMany(mappedBy = "usuario")
    private ContaCorrente contaCorrente;
}
