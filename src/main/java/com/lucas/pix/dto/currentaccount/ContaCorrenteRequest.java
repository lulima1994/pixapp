package com.lucas.pix.dto.currentaccount;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class ContaCorrenteRequest {
    private Long id;
    private Long bancoId;
    private Long usuarioId;
    private Integer agencia;
    private Integer conta;
    private BigDecimal saldo;
}
