package com.lucas.pix.rest.bank;

import com.lucas.pix.dto.bank.BancoRequest;
import com.lucas.pix.dto.bank.BancoResponse;
import com.lucas.pix.service.bank.BancoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
