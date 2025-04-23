package com.preparatorio.hackathon.agendamento_pagamentos.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerExceptions extends RuntimeException {

    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    public ResponseEntity<ErroResponse> usuarioNaoEncontradoException(UsuarioNaoEncontradoException ex) {
        ErroResponse erro = new ErroResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BoletoNaoEncontradoException.class)
    public ResponseEntity<ErroResponse> boletoNaoEncontradoException(BoletoNaoEncontradoException ex) {
        ErroResponse erro = new ErroResponse("Não foi encontrado um boleto.", HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CriarUsuarioException.class)
    public ResponseEntity<ErroResponse> criarUsuarioException(CriarUsuarioException ex) {
        ErroResponse erro = new ErroResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UsuariosNaoEncontradosException.class)
    public ResponseEntity<ErroResponse> usuariosNaoEncontradosException(UsuariosNaoEncontradosException ex) {
        ErroResponse erro = new ErroResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AlteracaoUsuarioException.class)
    public ResponseEntity<ErroResponse> alteracaoUsuarioException(AlteracaoUsuarioException ex) {
        ErroResponse erro = new ErroResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
    }

}
