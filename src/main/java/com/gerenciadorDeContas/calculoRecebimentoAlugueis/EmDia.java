package com.gerenciadorDeContas.calculoRecebimentoAlugueis;

import com.gerenciadorDeContas.model.ContasReceber;

import java.math.BigDecimal;

public class EmDia implements ICaulculoRecebimento{
    @Override
    public BigDecimal calculoRecebimento(ContasReceber contasReceber) {

       return contasReceber.getValorRecebimento();
    }
}
