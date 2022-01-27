package com.lucas.pix.service.user;

import com.lucas.pix.domain.model.Banco;
import com.lucas.pix.domain.repository.BancoRepository;
import com.lucas.pix.dto.user.BancoRequest;
import com.lucas.pix.dto.user.BancoResponse;
import com.lucas.pix.service.mapper.BancoMapper;
import com.lucas.pix.service.mapper.BancoResponseMapper;
import lombok.RequiredArgsConstructor;
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
        BancoResponse bancoResponse = bancoResponseMapper.mapear(banco);
        return bancoResponse;
    }

    public BancoResponse buscarPorId(Long id) {
        Optional<Banco> bancoOptional = bancoRepository.findById(id);
        if (bancoOptional.isEmpty())
            throw new RuntimeException("banco " + id + " nao encontrado");
        BancoResponse bancoResponse = bancoResponseMapper.mapear(bancoOptional.get());
        return bancoResponse;
    }
}
