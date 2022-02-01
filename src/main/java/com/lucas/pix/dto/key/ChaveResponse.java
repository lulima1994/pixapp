package com.lucas.pix.dto.key;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class ChaveResponse {
    private Long id;
    private String nomeContaCorrente;
    private String nomeTipoChave;
    private String valor;
}
