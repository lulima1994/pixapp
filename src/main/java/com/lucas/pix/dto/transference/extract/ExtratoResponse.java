package com.lucas.pix.dto.extract;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class ExtratoResponse {
    private Long id;
    private String tipo;
    private BigDecimal valor;
    private LocalDateTime dataHora;
}
