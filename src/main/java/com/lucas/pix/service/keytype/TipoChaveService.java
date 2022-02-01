package com.lucas.pix.service.keytype;

import com.lucas.pix.domain.model.TipoChave;
import com.lucas.pix.domain.repository.TipoChaveRepository;
import com.lucas.pix.dto.keytype.TipoChaveRequest;
import com.lucas.pix.dto.keytype.TipoChaveResponse;
import com.lucas.pix.service.mapper.keytype.TipoChaveMapper;
import com.lucas.pix.service.mapper.keytype.TipoChaveResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TipoChaveService {
    private final TipoChaveRepository tipoChaveRepository;
    private final TipoChaveMapper tipoChaveMapper;
    private final TipoChaveResponseMapper tipoChaveResponseMapper;

    public TipoChaveResponse salvar(TipoChaveRequest tipoChaveRequest) {
        TipoChave tipoChave = tipoChaveMapper.mapear(tipoChaveRequest);
        tipoChaveRepository.save(tipoChave);
        return tipoChaveResponseMapper.mapear(tipoChave);
    }

    public TipoChaveResponse buscarPorId(Long id) {
        Optional<TipoChave> tipoChaveOptional = tipoChaveRepository.findById(id);
        if (tipoChaveOptional.isEmpty())
            throw new RuntimeException("tipo de chave " + id + " nao encontrada");
        return tipoChaveResponseMapper.mapear(tipoChaveOptional.get());
    }

    public Page<TipoChaveResponse> buscarPorPagina(Pageable pageable) {
        Page<TipoChave> tipoChaves = tipoChaveRepository.findAll(pageable);
        return tipoChaves.map((cada) -> tipoChaveResponseMapper.mapear(cada));
    }

    public void deletarPorId(Long id) {
        tipoChaveRepository.deleteById(id);
    }
}
