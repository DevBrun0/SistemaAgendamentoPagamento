package com.preparatorio.hackathon.agendamento_pagamentos.domain;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Agendamento {

    @Id
    private String id;
    private LocalDateTime dataAgendamento;
    private Double valor;
    private String tipoPagamento;
    private String descricao;
    private Boleto boleto;


    public Agendamento(String id, LocalDateTime dataAgendamento, Double valor, String tipoPagamento, String descricao) {
        this.id = id;
        this.dataAgendamento = dataAgendamento;
        this.valor = valor;
        this.tipoPagamento = tipoPagamento;
        this.descricao = descricao;
        this.boleto = new Boleto();
    }

    public Agendamento(LocalDateTime dataAgendamento, Double valor, String tipoPagamento, String descricao, Boleto boleto) {
    }
}

