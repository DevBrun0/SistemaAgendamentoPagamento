package com.preparatorio.hackathon.agendamento_pagamentos.exceptions;

public class BoletoNaoEncontradoException extends RuntimeException {
    public BoletoNaoEncontradoException(String message) {
        super(message);
    }
}
