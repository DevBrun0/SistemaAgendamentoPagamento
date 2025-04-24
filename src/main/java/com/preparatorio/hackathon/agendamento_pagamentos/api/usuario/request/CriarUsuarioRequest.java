package com.preparatorio.hackathon.agendamento_pagamentos.api.usuario.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record CriarUsuarioRequest(
        @NotBlank(message = "Nome não pode ser vazio") String nome,
        @CPF(message = "Documento deve ser um CPF válido") String documento,
        String email,
        @NotBlank(message =  "Senha não pode ser nula") String senha
) {
}
