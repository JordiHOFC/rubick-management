package br.com.github.jordihofc.consultaformaspagamento;

import java.io.Serializable;

public enum TipoPagamento implements Serializable {

    CARTAO(false),
    DINHEIRO(true),
    MAQUINA(true),
    CHEQUE(true);


    TipoPagamento(boolean disponibilidadeOffline) {
        this.disponibilidadeOffline = disponibilidadeOffline;
    }
    private final boolean disponibilidadeOffline;
    public boolean isDisponibilidadeOffline() {
        return this.disponibilidadeOffline;
    }
}

