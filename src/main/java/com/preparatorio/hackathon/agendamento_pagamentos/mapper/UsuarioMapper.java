package com.preparatorio.hackathon.agendamento_pagamentos.mapper;

import com.preparatorio.hackathon.agendamento_pagamentos.api.usuario.request.CriarUsuarioRequest;
import com.preparatorio.hackathon.agendamento_pagamentos.api.usuario.response.UsuarioResponse;
import com.preparatorio.hackathon.agendamento_pagamentos.domain.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {
    public Usuario criarUsuarioRequestToUsuario(CriarUsuarioRequest criarUsuarioRequest) {
        return new Usuario(
                criarUsuarioRequest.nome(),
                criarUsuarioRequest.documento(),
                criarUsuarioRequest.email(),
                criarUsuarioRequest.senha()
        );
    }

    public UsuarioResponse usuarioToUsuarioResponse(Usuario usuario) {
        return new UsuarioResponse(
                usuario.getId(),
                usuario.getNome(),
                usuario.getDocumento(),
                usuario.getEmail()
        );
    }
}
