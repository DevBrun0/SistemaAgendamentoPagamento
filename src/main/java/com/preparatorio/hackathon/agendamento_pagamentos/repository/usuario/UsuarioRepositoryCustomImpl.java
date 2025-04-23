package com.preparatorio.hackathon.agendamento_pagamentos.repository.usuario;

import com.preparatorio.hackathon.agendamento_pagamentos.api.usuario.request.CriarUsuarioRequest;
import com.preparatorio.hackathon.agendamento_pagamentos.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component
public class UsuarioRepositoryCustomImpl implements UsuarioRepositoryCustom {

    @Autowired
    MongoTemplate mongoTemplate;

    public boolean alterarUsuario(String id, CriarUsuarioRequest criarUsuarioRequest) {
        Query query = new Query(Criteria.where("_id").is(id));

        Update update = new Update();
        if (criarUsuarioRequest.nome() != null) {
            update.set("nome", criarUsuarioRequest.nome());
        }
        if (criarUsuarioRequest.documento() != null) {
            update.set("documento", criarUsuarioRequest.documento());
        }
        if (criarUsuarioRequest.email() != null) {
            update.set("email", criarUsuarioRequest.email());
        }
        if (criarUsuarioRequest.senha() != null) {
            update.set("senha", criarUsuarioRequest.senha());
        }

        return mongoTemplate.updateFirst(query, update, Usuario.class)
                .getMatchedCount() > 0;
    }
}
