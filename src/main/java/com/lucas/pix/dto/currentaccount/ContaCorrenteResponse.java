package com.lucas.pix.dto.currentaccount;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class ContaCorrenteResponse {
    private Long id;
    private String nomeBanco;
    private String nomeUsuario;
    private Integer agencia;
    private Integer conta;
    private BigDecimal saldo;
}
