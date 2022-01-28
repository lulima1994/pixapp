package com.lucas.pix.service.mapper.user;

import com.lucas.pix.domain.model.Usuario;
import com.lucas.pix.dto.user.UsuarioRequest;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {
    public Usuario mapear(UsuarioRequest usuarioRequest) {
        Usuario usuario = new Usuario();
        usuario.setId(usuarioRequest.getId());
        usuario.setNome(usuarioRequest.getNome());
        usuario.setEmail(usuarioRequest.getEmail());
        usuario.setSenha(usuarioRequest.getSenha());
        return usuario;
    }
}
