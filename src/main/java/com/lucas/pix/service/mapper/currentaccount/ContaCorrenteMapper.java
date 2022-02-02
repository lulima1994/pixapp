package com.lucas.pix.service.mapper.currentaccount;

import com.lucas.pix.domain.model.ContaCorrente;
import com.lucas.pix.domain.repository.BancoRepository;
import com.lucas.pix.domain.repository.UsuarioRepository;
import com.lucas.pix.dto.currentaccount.ContaCorrenteRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContaCorrenteMapper {

    private final UsuarioRepository usuarioRepository;
    private final BancoRepository bancoRepository;

    public ContaCorrente mapear(ContaCorrenteRequest contaCorrenteRequest) {
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setUsuario(usuarioRepository.findById(contaCorrenteRequest.getUsuarioId()).orElseThrow());
        contaCorrente.setBanco(bancoRepository.findByCode(contaCorrenteRequest.getCodigo()).orElseThrow());
        contaCorrente.setId(contaCorrenteRequest.getId());
        contaCorrente.setAgencia(contaCorrenteRequest.getAgencia());
        contaCorrente.setConta(contaCorrenteRequest.getConta());
        contaCorrente.setSaldo(contaCorrenteRequest.getSaldo());
        return contaCorrente;
    }
}
