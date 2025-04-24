package com.preparatorio.hackathon.agendamento_pagamentos.service;

import com.preparatorio.hackathon.agendamento_pagamentos.exceptions.AlteracaoUsuarioException;
import com.preparatorio.hackathon.agendamento_pagamentos.exceptions.CriarUsuarioException;
import com.preparatorio.hackathon.agendamento_pagamentos.exceptions.UsuarioNaoEncontradoException;
import com.preparatorio.hackathon.agendamento_pagamentos.exceptions.UsuariosNaoEncontradosException;
import com.preparatorio.hackathon.agendamento_pagamentos.mapper.UsuarioMapper;
import com.preparatorio.hackathon.agendamento_pagamentos.api.usuario.request.CriarUsuarioRequest;
import com.preparatorio.hackathon.agendamento_pagamentos.api.usuario.response.UsuarioResponse;
import com.preparatorio.hackathon.agendamento_pagamentos.domain.Usuario;
import com.preparatorio.hackathon.agendamento_pagamentos.repository.UsuarioRepository;
import java.util.List;

import com.preparatorio.hackathon.agendamento_pagamentos.util.EncriptacaoSenha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper mapper;

    public UsuarioResponse criarUsuario(CriarUsuarioRequest criarUsuarioRequest) {
        Usuario usuario = mapper.criarUsuarioRequestToUsuario(criarUsuarioRequest);

        Usuario usuarioExistente = usuarioRepository.findByDocumento(usuario.getDocumento()).orElse(null);
        if (usuarioExistente != null) throw new CriarUsuarioException("Já existe um usuário cadastrado com este CPF!");

        var senhaHasheada = hashearSenha(usuario.getSenha());
        usuario.setSenha(senhaHasheada);

        Usuario usuarioCriado =  usuarioRepository.save(usuario);
        if (usuarioCriado.getId() == null) throw new CriarUsuarioException("Ocorreu algum erro na criação do usuário!");
        return mapper.usuarioToUsuarioResponse(usuario);
    }

    public List<UsuarioResponse> buscarTodosUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        if (usuarios.isEmpty()) throw new UsuariosNaoEncontradosException("Não foi possível encontrar os usuários!");
        return usuarios.stream()
                .map(usuario -> mapper.usuarioToUsuarioResponse(usuario))
                .toList();
    }

    public UsuarioResponse buscarUsuarioPorId( String id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException("Não foi possível encontrar esse usuário!"));
        return mapper.usuarioToUsuarioResponse(usuario);
    }

    public void alterarUsuario(String id, CriarUsuarioRequest alteracoes) {
        if (!usuarioRepository.alterarUsuario(id, alteracoes)) throw new AlteracaoUsuarioException("Não foi possível atualizar o usuário " + alteracoes.nome());
    }

    public String hashearSenha(String senha) {
        String senhaHasheada = EncriptacaoSenha.hashearSenha(senha);
        return senhaHasheada;
    }

    public boolean validarSenha(String senha, String senhaHasheada) {
        return EncriptacaoSenha.verificarSenha(senha, senhaHasheada);
    }

}
