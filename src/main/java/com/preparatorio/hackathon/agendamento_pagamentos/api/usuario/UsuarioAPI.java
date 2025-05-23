package com.preparatorio.hackathon.agendamento_pagamentos.api.usuario;

import com.preparatorio.hackathon.agendamento_pagamentos.api.usuario.request.CriarUsuarioRequest;
import com.preparatorio.hackathon.agendamento_pagamentos.api.usuario.response.UsuarioResponse;
import com.preparatorio.hackathon.agendamento_pagamentos.service.UsuarioService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioAPI {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity<String> postUsuario(@Valid @RequestBody CriarUsuarioRequest criarUsuarioRequest) {
        service.criarUsuario(criarUsuarioRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Usuário criado com sucesso!");
    }

    @GetMapping
    public ResponseEntity<?> getAllUsuarios() {
        List<UsuarioResponse> listaUsuarios = service.buscarTodosUsuarios();
        return ResponseEntity.ok(listaUsuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUsuario(@PathVariable String id) {
        UsuarioResponse usuario = service.buscarUsuarioPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUsuario(@PathVariable String id, @Valid @RequestBody CriarUsuarioRequest criarUsuarioRequest) {
        service.alterarUsuario(id, criarUsuarioRequest);
        return ResponseEntity.ok("Usuario alterado com sucesso!");
    }

}
