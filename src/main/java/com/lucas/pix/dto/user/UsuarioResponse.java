package com.lucas.pix.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class UsuarioResponse {
    private Long id;
    private String nome;
    private String email;
}
