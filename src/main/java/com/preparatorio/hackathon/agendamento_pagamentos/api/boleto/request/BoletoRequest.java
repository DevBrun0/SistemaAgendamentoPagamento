package com.preparatorio.hackathon.agendamento_pagamentos.api.boleto.request;

import com.preparatorio.hackathon.agendamento_pagamentos.api.usuario.response.UsuarioResponse;
import com.preparatorio.hackathon.agendamento_pagamentos.domain.Beneficiario;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoletoRequest {
    @NotNull(message = "Usuario não pode ser nulo.")
    private UsuarioResponse usuario;
    @NotNull(message = "Valor do banco não pode ser nulo.")
    private Double valor;
    @NotNull(message = "dataVencimento não pode ser nulo")
    private LocalDate dataVencimento;
    @NotNull(message = "Beneficiario não pode ser nulo.")
    private Beneficiario beneficiario;
}
