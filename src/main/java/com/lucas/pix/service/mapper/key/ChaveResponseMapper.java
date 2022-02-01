package com.lucas.pix.service.mapper.key;

import com.lucas.pix.domain.model.Chave;
import com.lucas.pix.dto.key.ChaveResponse;
import org.springframework.stereotype.Component;

@Component
public class ChaveResponseMapper {
    public ChaveResponse mapear(Chave chave) {
        ChaveResponse chaveResponse = new ChaveResponse();
        chaveResponse.setNomeContaCorrente(chave.getContaCorrente().getUsuario().getNome());
        chaveResponse.setNomeTipoChave(chave.getTipoChave().getNome());
        chaveResponse.setId(chave.getId());
        chaveResponse.setValor(chave.getValor());
        return chaveResponse;
    }
}
