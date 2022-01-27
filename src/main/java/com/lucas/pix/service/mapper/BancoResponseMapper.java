package com.lucas.pix.service.mapper;

import com.lucas.pix.domain.model.Banco;
import com.lucas.pix.dto.user.BancoResponse;
import org.springframework.stereotype.Component;

@Component
public class BancoResponseMapper {
    public BancoResponse mapear(Banco banco) {
        BancoResponse bancoResponse = new BancoResponse();
        bancoResponse.setId(banco.getId());
        bancoResponse.setNome(banco.getNome());
        bancoResponse.setCodigo(banco.getCodigo());
        return bancoResponse;
    }
}
