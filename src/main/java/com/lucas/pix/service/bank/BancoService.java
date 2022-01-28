package com.lucas.pix.service.bank;

import com.lucas.pix.domain.model.Banco;
import com.lucas.pix.domain.repository.BancoRepository;
import com.lucas.pix.dto.bank.BancoRequest;
import com.lucas.pix.dto.bank.BancoResponse;
import com.lucas.pix.service.mapper.bank.BancoMapper;
import com.lucas.pix.service.mapper.bank.BancoResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BancoService {
    private final BancoRepository bancoRepository;
    private final BancoResponseMapper bancoResponseMapper;
    private final BancoMapper bancoMapper;

    public BancoResponse salvar(BancoRequest bancoRequest) {
        Banco banco = bancoMapper.mapear(bancoRequest);
        bancoRepository.save(banco);
        return bancoResponseMapper.mapear(banco);
    }

    public BancoResponse buscarPorId(Long id) {
        Optional<Banco> bancoOptional = bancoRepository.findById(id);
        if (bancoOptional.isEmpty())
            throw new RuntimeException("banco " + id + " nao encontrado");
        return bancoResponseMapper.mapear(bancoOptional.get());
    }

    public Page<BancoResponse> buscarPorPagina(Pageable pageable) {
        Page<Banco> bancos = bancoRepository.findAll(pageable);
        return bancos.map((cada) -> bancoResponseMapper.mapear(cada));
    }

    public void deletarPorId(Long id) {
        bancoRepository.deleteById(id);
    }
}
