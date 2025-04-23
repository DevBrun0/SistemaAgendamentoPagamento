package com.preparatorio.hackathon.agendamento_pagamentos.repository.usuario;

import com.preparatorio.hackathon.agendamento_pagamentos.api.usuario.request.CriarUsuarioRequest;
import org.springframework.stereotype.Component;

@Component
public interface UsuarioRepositoryCustom {
    public boolean alterarUsuario(String id, CriarUsuarioRequest criarUsuarioRequest);
}
