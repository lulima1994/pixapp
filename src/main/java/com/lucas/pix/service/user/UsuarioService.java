package com.lucas.pix.service.user;

import com.lucas.pix.domain.model.Usuario;
import com.lucas.pix.domain.repository.UsuarioRepository;
import com.lucas.pix.dto.user.UsuarioRequest;
import com.lucas.pix.dto.user.UsuarioResponse;
import com.lucas.pix.service.mapper.user.UsuarioMapper;
import com.lucas.pix.service.mapper.user.UsuarioResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioResponseMapper usuarioResponseMapper;
    private final UsuarioMapper usuarioMapper;

    public UsuarioResponse salvar(UsuarioRequest usuarioRequest) {
        Usuario usuario = usuarioMapper.mapear(usuarioRequest);
        usuarioRepository.save(usuario);
        UsuarioResponse usuarioResponse = usuarioResponseMapper.mapear(usuario);
        return usuarioResponse;
    }

    public UsuarioResponse buscarPorId(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isEmpty())
            throw new RuntimeException("usuario " + id + " nao encontrado");
        UsuarioResponse usuarioResponse = usuarioResponseMapper.mapear(usuarioOptional.get());
        return usuarioResponse;
    }

    public Page<UsuarioResponse> buscarPorPagina(Pageable pageable) {
        Page<Usuario> usuarios = usuarioRepository.findAll(pageable);
        Page<UsuarioResponse> responses = usuarios.map((cada) -> usuarioResponseMapper.mapear(cada));
        return responses;
    }

    public void deletarPorId(Long id) {
        usuarioRepository.deleteById(id);
    }
}
