package com.preparatorio.hackathon.agendamento_pagamentos.util;

import org.mindrot.jbcrypt.BCrypt;

public class EncriptacaoSenha {

    public static String hashearSenha(String senha) {
        return BCrypt.hashpw(senha, BCrypt.gensalt());
    }

    public static boolean verificarSenha(String senha, String senhaHasheada) {
        return BCrypt.checkpw(senha, senhaHasheada);
    }
}
