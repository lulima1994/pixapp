package com.lucas.pix.dto.keytype;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class TipoChaveResponse {
    private Long id;
    private String nome;
}
