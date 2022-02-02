package com.lucas.pix.dto.bank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class BancoResponse {
    private Long id;
    private String nome;
    private String codigo;
}
