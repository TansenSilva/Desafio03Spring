package com.gerenciadorDeContas.calculoRecebimentoAlugueis;

import com.gerenciadorDeContas.model.ContasReceber;

import java.math.BigDecimal;

public class EmAtraso implements ICaulculoRecebimento{
    @Override
    public BigDecimal calculoRecebimento(ContasReceber contasReceber) {
        return contasReceber.getValorRecebimento().add(
                        contasReceber.getValorRecebimento().multiply(new
                        BigDecimal("0.035")));
    }
}
