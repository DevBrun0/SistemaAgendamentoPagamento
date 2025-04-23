package com.preparatorio.hackathon.agendamento_pagamentos.api.agendamento.request;

import com.preparatorio.hackathon.agendamento_pagamentos.domain.Boleto;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CriarAgendamentoRequest {

    private LocalDateTime dataAgendamento;
    private Double valor;
    private String tipoPagamento;
    private String descricao;
    private Boleto boleto;

}
