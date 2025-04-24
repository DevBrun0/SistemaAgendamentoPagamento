package com.preparatorio.hackathon.agendamento_pagamentos.mapper;

import com.preparatorio.hackathon.agendamento_pagamentos.api.agendamento.request.CriarAgendamentoRequest;
import com.preparatorio.hackathon.agendamento_pagamentos.domain.Agendamento;
import org.springframework.stereotype.Component;

@Component
public class AgendamentoMapper {

    public static Agendamento criarAgendamento(CriarAgendamentoRequest agendamentoRequest){
        return new Agendamento(
            agendamentoRequest.getDataAgendamento(),
            agendamentoRequest.getValor(),
            agendamentoRequest.getTipoPagamento(),
            agendamentoRequest.getDescricao(),
            agendamentoRequest.getBoleto()
        );
    }
}
