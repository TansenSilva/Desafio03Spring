package com.gerenciadorDeContas.calculoRecebimentoAlugueis;

import com.gerenciadorDeContas.model.ContasReceber;

import java.math.BigDecimal;

public class Adiantado implements ICaulculoRecebimento{

    @Override
    public BigDecimal calculoRecebimento(ContasReceber contasReceber) {
        return contasReceber.getValorRecebimento().subtract(
                contasReceber.getValorRecebimento().multiply(new
                        BigDecimal("0.05")));
    }
}
