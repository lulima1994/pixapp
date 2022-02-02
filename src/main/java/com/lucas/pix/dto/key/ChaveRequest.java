package com.lucas.pix.dto.key;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ChaveRequest {
    private Long id;
    private Integer agencia;
    private Integer conta;
    private String codigo;
    private String tipo;
    private String valor;
}
