package com.preparatorio.hackathon.agendamento_pagamentos.domain;

import com.preparatorio.hackathon.agendamento_pagamentos.api.usuario.response.UsuarioResponse;
import com.preparatorio.hackathon.agendamento_pagamentos.domain.enums.StatusBoleto;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Boleto{
        @Id
        private String id;
        private UsuarioResponse usuario;
        private String codigo;
        private Double valor;
        private LocalDate dataVencimento;
        private LocalDate dataPagamento;
        private LocalDate dataCriacao; //setando data de criação para metodo criarAgendamento
        private Beneficiario Beneficiario;
        private StatusBoleto status;

        public Boleto(UsuarioResponse usuario,  Double valor, LocalDate dataVencimento, Beneficiario beneficiario) {
                this.usuario = usuario;
                this.valor = valor;
                this.dataVencimento = dataVencimento;
                this.Beneficiario = beneficiario;
        }
}
