package com.lucas.pix.service.mapper.currentaccount;

import com.lucas.pix.domain.model.ContaCorrente;
import com.lucas.pix.dto.currentaccount.ContaCorrenteResponse;
import org.springframework.stereotype.Component;

@Component
public class ContaCorrenteResponseMapper {
    public ContaCorrenteResponse mapear(ContaCorrente contaCorrente){
        ContaCorrenteResponse contaCorrenteResponse = new ContaCorrenteResponse();
        contaCorrenteResponse.setId(contaCorrente.getId());
        contaCorrenteResponse.setAgencia(contaCorrente.getAgencia());
        contaCorrenteResponse.setConta(contaCorrente.getConta());
        contaCorrenteResponse.setSaldo(contaCorrente.getSaldo());
        return contaCorrenteResponse;
    }
}
