package com.gerenciadorDeContas.calculoRecebimentoAlugueis;

import com.gerenciadorDeContas.model.ContasReceber;

import java.math.BigDecimal;

public interface ICaulculoRecebimento {

    BigDecimal calculoRecebimento(ContasReceber contasReceber);
}
