package com.lucas.pix.service.mapper;

import com.lucas.pix.domain.model.Usuario;
import com.lucas.pix.dto.user.UsuarioResponse;
import org.springframework.stereotype.Component;

@Component
public class UsuarioResponseMapper {

    public UsuarioResponse mapear(Usuario usuario) {
        UsuarioResponse usuarioResponse = new UsuarioResponse();
        usuarioResponse.setId(usuario.getId());
        usuarioResponse.setNome(usuario.getNome());
        usuarioResponse.setEmail(usuario.getEmail());
        return usuarioResponse;
    }

}
