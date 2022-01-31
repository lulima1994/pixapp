package com.lucas.pix.service.mapper.currentaccount;

import com.lucas.pix.domain.model.ContaCorrente;
import com.lucas.pix.dto.currentaccount.ContaCorrenteRequest;
import org.springframework.stereotype.Component;

@Component
public class ContaCorrenteMapper {
    public ContaCorrente mapear(ContaCorrenteRequest contaCorrenteRequest){
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setId(contaCorrenteRequest.getId());
        contaCorrente.setAgencia(contaCorrenteRequest.getAgencia());
        contaCorrente.setConta(contaCorrenteRequest.getConta());
        contaCorrente.setSaldo(contaCorrenteRequest.getSaldo());
        return contaCorrente;
    }
}
