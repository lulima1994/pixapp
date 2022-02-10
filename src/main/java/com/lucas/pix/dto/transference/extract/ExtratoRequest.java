package com.lucas.pix.dto.extract;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ExtratoRequest {
    private Integer agencia;
    private Integer conta;
    private String codigo;
}
