package com.lucas.pix.service.mapper.keytype;

import com.lucas.pix.domain.model.TipoChave;
import com.lucas.pix.dto.keytype.TipoChaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TipoChaveMapper {
    public TipoChave mapear(TipoChaveRequest tipoChaveRequest) {
        TipoChave tipoChave = new TipoChave();
        tipoChave.setId(tipoChaveRequest.getId());
        tipoChave.setNome(tipoChaveRequest.getNome());
        return tipoChave;
    }
}
