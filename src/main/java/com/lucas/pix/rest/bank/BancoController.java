package com.lucas.pix.rest.bank;

import com.lucas.pix.dto.bank.BancoRequest;
import com.lucas.pix.dto.bank.BancoResponse;
import com.lucas.pix.service.bank.BancoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BancoController {

    private final BancoService bancoService;

    @PostMapping("/banco")
    public ResponseEntity<BancoResponse> adicionar(@RequestBody BancoRequest bancoRequest) {
        if (bancoRequest.getId() != null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        BancoResponse bancoResponse = bancoService.salvar(bancoRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bancoResponse);
    }

    @PutMapping("/banco")
    public ResponseEntity<BancoResponse> atualizar(@RequestBody BancoRequest bancoRequest) {
        if (bancoRequest.getId() == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        BancoResponse bancoResponse = bancoService.salvar(bancoRequest);
        return ResponseEntity.status(HttpStatus.OK)
                .body(bancoResponse);
    }

    @GetMapping("/banco/{id}")
    public ResponseEntity<BancoResponse> buscarPorId(@PathVariable Long id) {
        BancoResponse bancoResponse = bancoService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(bancoResponse);
    }

    @GetMapping("/banco")
    public ResponseEntity<Page<BancoResponse>> buscarPorPagina(Pageable pageable) {
        Page<BancoResponse> responses = bancoService.buscarPorPagina(pageable);
        return ResponseEntity.status(HttpStatus.OK)
                .body(responses);
    }

    @DeleteMapping("/banco/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        bancoService.deletarPorId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
