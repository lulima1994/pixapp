package com.lucas.pix.rest.keytype;

import com.lucas.pix.dto.keytype.TipoChaveRequest;
import com.lucas.pix.dto.keytype.TipoChaveResponse;
import com.lucas.pix.service.keytype.TipoChaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class TipoChaveController {

    private final TipoChaveService tipoChaveService;

    @PostMapping("/tipochave")
    public ResponseEntity<TipoChaveResponse> adicionar(@RequestBody TipoChaveRequest tipoChaveRequest) {
        if (tipoChaveRequest.getId() != null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        TipoChaveResponse tipoChaveResponse = tipoChaveService.salvar(tipoChaveRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(tipoChaveResponse);
    }

    @PutMapping("/tipochave")
    public ResponseEntity<TipoChaveResponse> atualizar(@RequestBody TipoChaveRequest tipoChaveRequest) {
        if (tipoChaveRequest.getId() == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        TipoChaveResponse tipoChaveResponse = tipoChaveService.salvar(tipoChaveRequest);
        return ResponseEntity.status(HttpStatus.OK)
                .body(tipoChaveResponse);
    }

    @GetMapping("/tipochave/{id}")
    public ResponseEntity<TipoChaveResponse> buscarPorId(@PathVariable Long id) {
        TipoChaveResponse tipoChaveResponse = tipoChaveService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(tipoChaveResponse);
    }

    @GetMapping("/tipochave")
    public ResponseEntity<Page<TipoChaveResponse>> buscarPorPagina(Pageable pageable) {
        Page<TipoChaveResponse> responses = tipoChaveService.buscarPorPagina(pageable);
        return ResponseEntity.status(HttpStatus.OK)
                .body(responses);
    }

    @DeleteMapping("/tipochave/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        tipoChaveService.deletarPorId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
