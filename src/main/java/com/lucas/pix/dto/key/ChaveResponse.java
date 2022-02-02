package com.lucas.pix.dto.key;

import com.lucas.pix.dto.currentaccount.ContaCorrenteResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class ChaveResponse {
    private ContaCorrenteResponse contaCorrente;
    private Long id;
    private String tipo;
    private String valor;
}
