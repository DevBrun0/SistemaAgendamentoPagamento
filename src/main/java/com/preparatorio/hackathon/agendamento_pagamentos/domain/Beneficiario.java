package com.preparatorio.hackathon.agendamento_pagamentos.domain;

import jakarta.validation.constraints.NotBlank;

public record Beneficiario(
        @NotBlank String bancoDestino,
        @NotBlank String contaDestino,
        @NotBlank String nomeBeneficiario,
        @NotBlank String documentoBeneficiario
) {
}
