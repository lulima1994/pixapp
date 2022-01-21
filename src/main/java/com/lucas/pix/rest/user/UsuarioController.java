package com.lucas.pix.rest.user;

import com.lucas.pix.dto.user.UsuarioRequest;
import com.lucas.pix.dto.user.UsuarioResponse;
import com.lucas.pix.service.user.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/usuario")
    public ResponseEntity<UsuarioResponse> adicionar(@RequestBody UsuarioRequest usuarioRequest) {
        if (usuarioRequest.getId() != null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        UsuarioResponse usuarioResponse = usuarioService.salvar(usuarioRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usuarioResponse);
    }

    @PutMapping("/usuario")
    public ResponseEntity<UsuarioResponse> atualizar(@RequestBody UsuarioRequest usuarioRequest) {
        if (usuarioRequest.getId() == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        UsuarioResponse usuarioResponse = usuarioService.salvar(usuarioRequest);
        return ResponseEntity.status(HttpStatus.OK)
                .body(usuarioResponse);
    }
}
