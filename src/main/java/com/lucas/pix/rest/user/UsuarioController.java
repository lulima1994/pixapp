package com.lucas.pix.rest.user;

import com.lucas.pix.dto.user.UsuarioRequest;
import com.lucas.pix.dto.user.UsuarioResponse;
import com.lucas.pix.service.user.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/usuario/{id}")
    public ResponseEntity<UsuarioResponse> buscarPorId(@PathVariable Long id) {
        UsuarioResponse usuarioResponse = usuarioService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(usuarioResponse);
    }

    @GetMapping("/usuario")
    public ResponseEntity<Page<UsuarioResponse>> buscarPorPagina(Pageable pageable) {
        Page<UsuarioResponse> responses = usuarioService.buscarPorPagina(pageable);
        return ResponseEntity.status(HttpStatus.OK)
                .body(responses);
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        usuarioService.deletarPorId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
