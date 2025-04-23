package com.preparatorio.hackathon.agendamento_pagamentos.api.usuario.response;

public record UsuarioResponse(
        String id,
        String nome,
        String documento,
        String email) {
}
