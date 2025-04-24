package com.preparatorio.hackathon.agendamento_pagamentos.repository;

import com.preparatorio.hackathon.agendamento_pagamentos.domain.Usuario;
import com.preparatorio.hackathon.agendamento_pagamentos.repository.usuario.UsuarioRepositoryCustom;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String>, UsuarioRepositoryCustom {
    Optional<Usuario> findByDocumento(String documento);
}
