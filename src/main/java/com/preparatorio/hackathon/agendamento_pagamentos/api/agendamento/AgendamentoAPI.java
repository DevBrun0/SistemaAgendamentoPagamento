package com.preparatorio.hackathon.agendamento_pagamentos.api.agendamento;

import com.preparatorio.hackathon.agendamento_pagamentos.api.agendamento.request.CriarAgendamentoRequest;
import com.preparatorio.hackathon.agendamento_pagamentos.domain.Agendamento;
import com.preparatorio.hackathon.agendamento_pagamentos.service.AgendamentoService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
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
@RequestMapping("/agendamento")
public class AgendamentoAPI {

    @Autowired
    private AgendamentoService agendamentoService;

    @GetMapping
    public ResponseEntity<?> listarTodosAgendamento(){
        List<Agendamento> todosAgendamentos = agendamentoService.listarTodosAgendamentos();

        if(!todosAgendamentos.isEmpty()){
            return ResponseEntity.ok(todosAgendamentos);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Não foi possível encontrar esse agendamento.");
    }

    @GetMapping({"/id"})
    public ResponseEntity<?> listarAgendamentoPorId(@PathVariable String id){
        Agendamento agendamentosId = agendamentoService.buscarAgendamentoPorId(id);

        if(agendamentosId != null){
            return ResponseEntity.status(HttpStatus.OK).body(agendamentosId);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Não foi possível encontrar esse agendamento.");
    }

    @PostMapping
    public ResponseEntity<?> cadastrarAgendamento(@Valid @RequestBody CriarAgendamentoRequest criarAgendamentoRequest){
        Agendamento criarAgendamento = agendamentoService.criarAgendamento(criarAgendamentoRequest);

        if(criarAgendamento != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(criarAgendamento);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Não foi possível criar esse agendamento.");

    }

    @PutMapping({"/id"})
    public ResponseEntity<?> atualizarAgendamento(Agendamento agendamento){
        Agendamento atualizarAgendamento = agendamentoService.atualizarAgendamento(agendamento);


        if(atualizarAgendamento != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(atualizarAgendamento);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Não foi possível atualizar esse agendamento.");
    }

    @DeleteMapping({"/id"})
    public ResponseEntity<?> deletarAgendamento(@PathVariable String id){
        Agendamento agendamentoDeletado = agendamentoService.deletarAgendamento(id);

        if(agendamentoDeletado != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(agendamentoDeletado);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Não foi possível deletar esse agendamento.");
    }
}
