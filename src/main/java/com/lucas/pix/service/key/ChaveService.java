package com.lucas.pix.service.key;

import com.lucas.pix.domain.model.Chave;
import com.lucas.pix.domain.model.ContaCorrente;
import com.lucas.pix.domain.repository.ChaveRepository;
import com.lucas.pix.dto.currentaccount.ContaCorrenteRequest;
import com.lucas.pix.dto.currentaccount.ContaCorrenteResponse;
import com.lucas.pix.dto.key.ChaveRequest;
import com.lucas.pix.dto.key.ChaveResponse;
import com.lucas.pix.service.mapper.key.ChaveMapper;
import com.lucas.pix.service.mapper.key.ChaveResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ChaveService {
    private final ChaveRepository chaveRepository;
    private final ChaveMapper chaveMapper;
    private final ChaveResponseMapper chaveResponseMapper;

    public ChaveResponse salvar(ChaveRequest chaveRequest) {
        Chave chave = chaveMapper.mapear(chaveRequest);
        chaveRepository.save(chave);
        return chaveResponseMapper.mapear(chave);
    }

    public ChaveResponse buscarPorId(Long id) {
        Optional<Chave> chaveOptional = chaveRepository.findById(id);
        if (chaveOptional.isEmpty())
            throw new RuntimeException("chave " + id + " nao encontrada");
        return chaveResponseMapper.mapear(chaveOptional.get());
    }

    public Page<ChaveResponse> buscarPorPagina(Pageable pageable) {
        Page<Chave> chaves = chaveRepository.findAll(pageable);
        return chaves.map((cada) -> chaveResponseMapper.mapear(cada));
    }

    public void deletarPorId(Long id) {
        chaveRepository.deleteById(id);
    }
}
