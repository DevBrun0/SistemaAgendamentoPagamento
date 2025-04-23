package com.preparatorio.hackathon.agendamento_pagamentos.mapper;

import com.preparatorio.hackathon.agendamento_pagamentos.api.boleto.request.BoletoRequest;
import com.preparatorio.hackathon.agendamento_pagamentos.domain.Boleto;
import com.preparatorio.hackathon.agendamento_pagamentos.domain.enums.StatusBoleto;

public class BoletoMapper {
    public static Boleto map(BoletoRequest boletoRequest) {
        return new Boleto(
                boletoRequest.getUsuario(),
                boletoRequest.getValor(),
                boletoRequest.getDataVencimento(),
                boletoRequest.getBeneficiario()
        );
    }
}
