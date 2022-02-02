package com.lucas.pix.service.mapper.key;

import com.lucas.pix.domain.model.Chave;
import com.lucas.pix.dto.key.ChaveResponse;
import com.lucas.pix.service.mapper.currentaccount.ContaCorrenteResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChaveResponseMapper {
    private final ContaCorrenteResponseMapper contaCorrenteResponseMapper;

    public ChaveResponse mapear(Chave chave) {
        ChaveResponse chaveResponse = new ChaveResponse();
        chaveResponse.setContaCorrente(contaCorrenteResponseMapper.mapear(chave.getContaCorrente()));
        chaveResponse.setTipo(chave.getTipoChave().getNome());
        chaveResponse.setId(chave.getId());
        chaveResponse.setValor(chave.getValor());
        return chaveResponse;
    }
}
