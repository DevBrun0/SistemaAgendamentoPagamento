package com.preparatorio.hackathon.agendamento_pagamentos.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;

@Data
@EqualsAndHashCode
public class Usuario {
    @Id String id;
    @NotBlank(message = "Nome não pode ser vazio") String nome;
    @CPF(message = "Documento deve ser um CPF válido") String documento;
    String email;
    @NotNull(message =  "Senha não pode ser nula") String senha;

    public Usuario(String nome, String documento, String email, String senha) {
        this.nome = nome;
        this.documento = documento;
        this.email = email;
        this.senha = senha;
    }

}
