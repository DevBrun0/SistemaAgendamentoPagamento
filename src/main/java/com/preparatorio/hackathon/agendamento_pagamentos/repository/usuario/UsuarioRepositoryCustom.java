package com.preparatorio.hackathon.agendamento_pagamentos.repository.usuario;

import com.preparatorio.hackathon.agendamento_pagamentos.api.usuario.request.CriarUsuarioRequest;
import com.preparatorio.hackathon.agendamento_pagamentos.domain.Usuario;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface UsuarioRepositoryCustom {
    boolean alterarUsuario(String id, CriarUsuarioRequest criarUsuarioRequest);
}
