package com.lucas.pix.dto.user;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UsuarioRequest {
    private Long id;
    private String nome;
    private String email;
    private String senha;
}
