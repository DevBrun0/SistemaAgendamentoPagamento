package com.preparatorio.hackathon.agendamento_pagamentos.exceptions;

import org.springframework.http.HttpStatus;

public record ErroResponse(String mensagem, int statusCode) {
}