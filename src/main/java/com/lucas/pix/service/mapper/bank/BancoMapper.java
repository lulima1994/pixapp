package com.lucas.pix.service.mapper.bank;

import com.lucas.pix.domain.model.Banco;
import com.lucas.pix.dto.bank.BancoRequest;
import org.springframework.stereotype.Component;

@Component
public class BancoMapper {
    public Banco mapear(BancoRequest bancoRequest) {
        Banco banco = new Banco();
        banco.setId(bancoRequest.getId());
        banco.setNome(bancoRequest.getNome());
        banco.setCodigo(bancoRequest.getCodigo());
        return banco;
    }
}
