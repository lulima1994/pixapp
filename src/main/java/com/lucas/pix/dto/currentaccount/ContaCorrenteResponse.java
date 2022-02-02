package com.lucas.pix.dto.currentaccount;

import com.lucas.pix.dto.bank.BancoResponse;
import com.lucas.pix.dto.user.UsuarioResponse;
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
    private UsuarioResponse usuario;
    private BancoResponse banco;
    private Long id;
    private Integer agencia;
    private Integer conta;
    private BigDecimal saldo;
}
