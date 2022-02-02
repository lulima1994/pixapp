package com.lucas.pix.service.mapper.currentaccount;

import com.lucas.pix.domain.model.ContaCorrente;
import com.lucas.pix.dto.currentaccount.ContaCorrenteResponse;
import com.lucas.pix.service.mapper.bank.BancoResponseMapper;
import com.lucas.pix.service.mapper.user.UsuarioResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContaCorrenteResponseMapper {
    private final UsuarioResponseMapper usuarioResponseMapper;
    private final BancoResponseMapper bancoResponseMapper;

    public ContaCorrenteResponse mapear(ContaCorrente contaCorrente) {
        ContaCorrenteResponse contaCorrenteResponse = new ContaCorrenteResponse();
        contaCorrenteResponse.setUsuario(usuarioResponseMapper.mapear(contaCorrente.getUsuario()));
        contaCorrenteResponse.setBanco(bancoResponseMapper.mapear(contaCorrente.getBanco()));
        contaCorrenteResponse.setId(contaCorrente.getId());
        contaCorrenteResponse.setAgencia(contaCorrente.getAgencia());
        contaCorrenteResponse.setConta(contaCorrente.getConta());
        contaCorrenteResponse.setSaldo(contaCorrente.getSaldo());
        return contaCorrenteResponse;
    }
}
