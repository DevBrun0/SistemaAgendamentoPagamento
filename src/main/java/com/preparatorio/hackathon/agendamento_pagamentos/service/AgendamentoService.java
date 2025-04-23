package com.preparatorio.hackathon.agendamento_pagamentos.service;

import com.preparatorio.hackathon.agendamento_pagamentos.api.agendamento.request.CriarAgendamentoRequest;
import com.preparatorio.hackathon.agendamento_pagamentos.domain.Agendamento;
import com.preparatorio.hackathon.agendamento_pagamentos.domain.enums.StatusBoleto;
import com.preparatorio.hackathon.agendamento_pagamentos.mapper.AgendamentoMapper;
import com.preparatorio.hackathon.agendamento_pagamentos.repository.AgendamentoRepository;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class AgendamentoService {
    @Autowired
    private final AgendamentoRepository agendamentoRepository;
    @Autowired
    private BoletoService boletoService;
    @Autowired
    private static AgendamentoMapper agendamentoMapper;

    public AgendamentoService(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }

    public Agendamento criarAgendamento(CriarAgendamentoRequest criarAgendamentoRequest) {
        Agendamento agendamentoSalvo = agendamentoMapper.criarAgendamento(criarAgendamentoRequest);
        boletoService.atualizarStatusBoleto(agendamentoSalvo.getBoleto().getId(), StatusBoleto.AGENDADO);
        return salvarAgendamento(agendamentoSalvo);
    }

    public Agendamento salvarAgendamento(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    public List<Agendamento> listarTodosAgendamentos(){
        return agendamentoRepository.findAll();
    }

    public Agendamento buscarAgendamentoPorId(@PathVariable String id){
         return agendamentoRepository.findById(id).orElse(null);
    }

    public Agendamento deletarAgendamento(@PathVariable String id){
        Agendamento agendamento = agendamentoRepository.findById(id).orElse(null);
        agendamentoRepository.deleteById(id);
        return agendamento;
    }

    public Agendamento atualizarAgendamento(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

}
