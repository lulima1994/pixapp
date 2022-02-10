package com.lucas.pix.service.extract;

import com.lucas.pix.domain.model.Transacao;
import com.lucas.pix.domain.repository.TransacaoRepository;
import com.lucas.pix.dto.extract.ExtratoResponse;
import com.lucas.pix.dto.transference.TransacaoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ExtratoService {
    private final TransacaoRepository transacaoRepository;

    public Page<ExtratoResponse> buscarPorPagina(TransacaoRequest transacaoRequest) {
        Page<Transacao> transacaos = transacaoRepository.findByAccount(transacaoRequest.getAgencia(), transacaoRequest.getConta(), transacaoRequest.getCodigo());
        return null;
    }
}
