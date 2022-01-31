package com.lucas.pix.rest.currentaccount;

import com.lucas.pix.dto.currentaccount.ContaCorrenteRequest;
import com.lucas.pix.dto.currentaccount.ContaCorrenteResponse;
import com.lucas.pix.service.currentaccount.ContaCorrenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ContaCorrenteController {

    private final ContaCorrenteService contaCorrenteService;

    @PostMapping("/contacorrente")
    public ResponseEntity<ContaCorrenteResponse> adicionar(@RequestBody ContaCorrenteRequest contaCorrenteRequest) {
        if (contaCorrenteRequest.getId() != null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        ContaCorrenteResponse contaCorrenteResponse = contaCorrenteService.salvar(contaCorrenteRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(contaCorrenteResponse);
    }

    @PutMapping("/contacorrente")
    public ResponseEntity<ContaCorrenteResponse> atualizar(@RequestBody ContaCorrenteRequest contaCorrenteRequest) {
        if (contaCorrenteRequest.getId() == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        ContaCorrenteResponse contaCorrenteResponse = contaCorrenteService.salvar(contaCorrenteRequest);
        return ResponseEntity.status(HttpStatus.OK)
                .body(contaCorrenteResponse);
    }

    @GetMapping("/contacorrente/{id}")
    public ResponseEntity<ContaCorrenteResponse> buscarPorId(@PathVariable Long id) {
        ContaCorrenteResponse contaCorrenteResponse = contaCorrenteService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(contaCorrenteResponse);
    }

    @GetMapping("/contacorrente")
    public ResponseEntity<Page<ContaCorrenteResponse>> buscarPorPagina(Pageable pageable) {
        Page<ContaCorrenteResponse> responses = contaCorrenteService.buscarPorPagina(pageable);
        return ResponseEntity.status(HttpStatus.OK)
                .body(responses);
    }

    @DeleteMapping("/contacorrente/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        contaCorrenteService.deletarPorId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
