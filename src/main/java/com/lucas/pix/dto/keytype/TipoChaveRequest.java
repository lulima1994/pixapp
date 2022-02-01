package com.lucas.pix.dto.keytype;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TipoChaveRequest {
    private Long id;
    private String nome;
}
