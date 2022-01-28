package com.lucas.pix.dto.bank;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BancoRequest {
    private Long id;
    private String nome;
    private Integer codigo;
}
