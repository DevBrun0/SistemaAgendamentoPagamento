package com.preparatorio.hackathon.agendamento_pagamentos.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
@EqualsAndHashCode
public class Usuario {
    @Id
    String id;
    String nome;
    @Indexed(unique = true)
    String documento;
    String email;
    String senha;

    public Usuario(String nome, String documento, String email, String senha) {
        this.nome = nome;
        this.documento = documento;
        this.email = email;
        this.senha = senha;
    }

}
