package com.lucas.pix.dto.key;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ChaveRequest {
    private Long id;
    private Long contaCorrenteId;
    private String tipo;
    private String valor;
}
