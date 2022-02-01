package com.lucas.pix.rest.key;

import com.lucas.pix.dto.key.ChaveRequest;
import com.lucas.pix.dto.key.ChaveResponse;
import com.lucas.pix.service.key.ChaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ChaveController {

    private final ChaveService chaveService;

    @PostMapping("/chave")
    public ResponseEntity<ChaveResponse> adicionar(@RequestBody ChaveRequest chaveRequest) {
        if (chaveRequest.getId() != null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        ChaveResponse chaveResponse = chaveService.salvar(chaveRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(chaveResponse);
    }

    @PutMapping("/chave")
    public ResponseEntity<ChaveResponse> atualizar(@RequestBody ChaveRequest chaveRequest) {
        if (chaveRequest.getId() == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        ChaveResponse chaveResponse = chaveService.salvar(chaveRequest);
        return ResponseEntity.status(HttpStatus.OK)
                .body(chaveResponse);
    }

    @GetMapping("/chave/{id}")
    public ResponseEntity<ChaveResponse> buscarPorId(@PathVariable Long id) {
        ChaveResponse chaveResponse = chaveService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(chaveResponse);
    }

    @GetMapping("/chave")
    public ResponseEntity<Page<ChaveResponse>> buscarPorPagina(Pageable pageable) {
        Page<ChaveResponse> responses = chaveService.buscarPorPagina(pageable);
        return ResponseEntity.status(HttpStatus.OK)
                .body(responses);
    }

    @DeleteMapping("/chave/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        chaveService.deletarPorId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
