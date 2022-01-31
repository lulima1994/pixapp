package com.lucas.pix.service.currentaccount;

import com.lucas.pix.domain.model.ContaCorrente;
import com.lucas.pix.domain.repository.ContaCorrenteRepository;
import com.lucas.pix.dto.currentaccount.ContaCorrenteRequest;
import com.lucas.pix.dto.currentaccount.ContaCorrenteResponse;
import com.lucas.pix.service.mapper.currentaccount.ContaCorrenteMapper;
import com.lucas.pix.service.mapper.currentaccount.ContaCorrenteResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ContaCorrenteService {
    private final ContaCorrenteMapper contaCorrenteMapper;
    private final ContaCorrenteRepository contaCorrenteRepository;
    private final ContaCorrenteResponseMapper contaCorrenteResponseMapper;

    public ContaCorrenteResponse salvar(ContaCorrenteRequest contaCorrenteRequest) {
        ContaCorrente contaCorrente = contaCorrenteMapper.mapear(contaCorrenteRequest);
        contaCorrenteRepository.save(contaCorrente);
        return contaCorrenteResponseMapper.mapear(contaCorrente);
    }

    public ContaCorrenteResponse buscarPorId(Long id) {
        Optional<ContaCorrente> contaCorrenteOptional = contaCorrenteRepository.findById(id);
        if (contaCorrenteOptional.isEmpty())
            throw new RuntimeException("conta corrente " + id + " nao encontrada");
        return contaCorrenteResponseMapper.mapear(contaCorrenteOptional.get());
    }

    public Page<ContaCorrenteResponse> buscarPorPagina(Pageable pageable) {
        Page<ContaCorrente> contaCorrentes = contaCorrenteRepository.findAll(pageable);
        return contaCorrentes.map((cada) -> contaCorrenteResponseMapper.mapear(cada));
    }

    public void deletarPorId(Long id) {
        contaCorrenteRepository.deleteById(id);
    }
}
