package com.preparatorio.hackathon.agendamento_pagamentos.service;

import com.preparatorio.hackathon.agendamento_pagamentos.api.boleto.request.BoletoRequest;
import com.preparatorio.hackathon.agendamento_pagamentos.domain.Boleto;
import com.preparatorio.hackathon.agendamento_pagamentos.domain.enums.StatusBoleto;
import com.preparatorio.hackathon.agendamento_pagamentos.mapper.BoletoMapper;
import com.preparatorio.hackathon.agendamento_pagamentos.repository.BoletoRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoletoService {
    @Autowired
    private BoletoRepository boletoRepository;

    public Boleto criarBoleto(BoletoRequest boletoRequest) {
        Boleto novoBoleto = BoletoMapper.map(boletoRequest);

        novoBoleto.setDataCriacao(LocalDate.now());
        novoBoleto.setStatus(StatusBoleto.EM_ABERTO);
        novoBoleto.setCodigo(
                //todo gerar código numerico do boleto
                "11112 2222222 3333333 444444"
        );

        return boletoRepository.save(novoBoleto);
    }

    public List<Boleto> listarBoletos() {
        return boletoRepository.findAll();
    }

    public List<Boleto> listarBoletosUsuario(String id) {
        return boletoRepository.findByUsuario_Id(id);
    }

    public Optional<Boleto> buscarBoletoPorId(String id) {
        return boletoRepository.findById(id);
    }

    public Boleto atualizarStatusBoleto(String id, Boleto boleto, StatusBoleto statusBoleto) {
            boleto.setStatus(statusBoleto);
            return boletoRepository.save(boleto);
    }

    public void deletarBoleto(String id) {
        boletoRepository.findById(id).ifPresent(boleto -> {
            boletoRepository.delete(boleto);
        });
    }
}
