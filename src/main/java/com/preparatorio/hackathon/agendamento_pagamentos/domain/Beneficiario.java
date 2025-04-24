package com.preparatorio.hackathon.agendamento_pagamentos.domain;

import jakarta.validation.constraints.NotBlank;

public record Beneficiario(
        @NotBlank(message = "Banco destino não pode ser vazio.") String bancoDestino,
        @NotBlank(message = "Conta destino não pode ser vazia.") String contaDestino,
        @NotBlank(message = "Nome do beneficiário não pode ser vazio.") String nomeBeneficiario,
        @NotBlank(message = "Documento do beneficiário não pode ser vazio.") String documentoBeneficiario
) {
}

