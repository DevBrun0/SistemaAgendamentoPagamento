package com.preparatorio.hackathon.agendamento_pagamentos.repository;

import com.preparatorio.hackathon.agendamento_pagamentos.domain.Boleto;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoletoRepository extends MongoRepository<Boleto, String> {
    List<Boleto> findByUsuario_Id(String usuarioId);
}
