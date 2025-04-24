package com.preparatorio.hackathon.agendamento_pagamentos.api.boleto;

import com.preparatorio.hackathon.agendamento_pagamentos.api.boleto.request.BoletoRequest;
import com.preparatorio.hackathon.agendamento_pagamentos.domain.Boleto;
import com.preparatorio.hackathon.agendamento_pagamentos.domain.enums.StatusBoleto;
import com.preparatorio.hackathon.agendamento_pagamentos.exceptions.BoletoNaoEncontradoException;
import com.preparatorio.hackathon.agendamento_pagamentos.service.BoletoService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boleto")
public class BoletoAPI {
    @Autowired
    private BoletoService boletoService;

    @PostMapping
    public ResponseEntity<?> criarBoleto(@RequestBody @Valid BoletoRequest boletoRequest) {
        Boleto boleto = boletoService.criarBoleto(boletoRequest);
        if (boleto !=null) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping
    public ResponseEntity<?> buscarTodosBoletos() {
        List<Boleto> boletos = boletoService.listarBoletos();
        if (boletos != null) {
            return ResponseEntity.status(HttpStatus.OK).body(boletos);
        } return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> buscarBoletosUsuario(@PathVariable @Valid String id) {
        List<Boleto> boletosUsuario = boletoService.listarBoletosUsuario(id);
        if (boletosUsuario != null) {
            return ResponseEntity.status(HttpStatus.OK).body(boletosUsuario);
        } return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarBoletosPorId(@PathVariable @Valid String id) {
        Optional<Boleto> boleto = boletoService.buscarBoletoPorId(id);
        if (boleto.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(boleto);
        } return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarBoleto(@PathVariable @Valid String id, @RequestBody StatusBoleto statusBoleto) {
        Boleto boleto = boletoService.buscarBoletoPorId(id).orElseThrow(() -> new BoletoNaoEncontradoException("Boleto não encontrado!"));
        Boleto boletoAtualizado = boletoService.atualizarStatusBoleto(id, boleto, statusBoleto);
        return ResponseEntity.status(HttpStatus.OK).body(boletoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarBoleto(@PathVariable @Valid String id) {
        boletoService.deletarBoleto(id);
        if(buscarBoletosPorId(id) == null){
            return ResponseEntity.status(HttpStatus.OK).build();
        } else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
