package com.lucas.pix.service.mapper.keytype;

import com.lucas.pix.domain.model.TipoChave;
import com.lucas.pix.dto.keytype.TipoChaveResponse;
import org.springframework.stereotype.Component;

@Component
public class TipoChaveResponseMapper {
    public TipoChaveResponse mapear(TipoChave tipoChave) {
        TipoChaveResponse tipoChaveResponse = new TipoChaveResponse();
        tipoChaveResponse.setId(tipoChave.getId());
        tipoChaveResponse.setNome(tipoChave.getNome());
        return tipoChaveResponse;
    }
}
