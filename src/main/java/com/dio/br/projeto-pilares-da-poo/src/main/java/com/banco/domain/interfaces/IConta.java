package com.banco.domain.interfaces;

import com.banco.domain.entities.Conta;

public interface IConta {

    void sacar(double valor);

    void depositar(double valor);

    void transferir(double valor, Conta contaDestino);
}
