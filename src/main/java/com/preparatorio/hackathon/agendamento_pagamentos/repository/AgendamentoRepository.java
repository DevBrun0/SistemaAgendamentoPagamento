package com.preparatorio.hackathon.agendamento_pagamentos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.preparatorio.hackathon.agendamento_pagamentos.domain.Agendamento;

@Repository
public interface AgendamentoRepository extends MongoRepository<Agendamento, String> {
}
