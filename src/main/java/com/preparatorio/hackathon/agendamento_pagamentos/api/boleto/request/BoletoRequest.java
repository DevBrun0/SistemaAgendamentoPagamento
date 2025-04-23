package com.preparatorio.hackathon.agendamento_pagamentos.api.boleto.request;

import com.preparatorio.hackathon.agendamento_pagamentos.api.usuario.response.UsuarioResponse;
import com.preparatorio.hackathon.agendamento_pagamentos.domain.Beneficiario;
import com.preparatorio.hackathon.agendamento_pagamentos.domain.Usuario;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoletoRequest {
    @NotBlank(message = "Usuario não pode ser nulo.")
    private UsuarioResponse usuario;
    @NotBlank(message = "Valor do banco não pode ser nulo.")
    private Double valor;
    @NotBlank(message = "dataVencimento não pode ser nulo")
    private LocalDate dataVencimento;
    @NotBlank(message = "Beneficiario não pode ser nulo.")
    private Beneficiario beneficiario;
}
