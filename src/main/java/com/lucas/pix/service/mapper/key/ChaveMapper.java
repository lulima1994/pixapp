package com.lucas.pix.service.mapper.key;

import com.lucas.pix.domain.model.Chave;
import com.lucas.pix.domain.repository.ContaCorrenteRepository;
import com.lucas.pix.domain.repository.TipoChaveRepository;
import com.lucas.pix.dto.key.ChaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChaveMapper {

    private final ContaCorrenteRepository contaCorrenteRepository;
    private final TipoChaveRepository tipoChaveRepository;

    public Chave mapear(ChaveRequest chaveRequest) {
        Chave chave = new Chave();
        chave.setContaCorrente(contaCorrenteRepository
                .findByAccount(chaveRequest.getAgencia(), chaveRequest.getConta(), chaveRequest.getCodigo())
                .orElseThrow());
        chave.setTipoChave(tipoChaveRepository.findByName(chaveRequest.getTipo()).orElseThrow());
        chave.setId(chaveRequest.getId());
        chave.setValor(chaveRequest.getValor());
        return chave;
    }
}
