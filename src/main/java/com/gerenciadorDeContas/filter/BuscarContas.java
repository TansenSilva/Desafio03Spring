package com.gerenciadorDeContas.filter;

import com.gerenciadorDeContas.Enum.Status;

public interface BuscarContas {

    Long getId();
    String getNome();
    double getValor();
    Status getStatus();
}
