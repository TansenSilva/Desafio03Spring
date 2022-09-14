package com.gerenciadorDeContas.calculoRecebimentoAlugueis;

import com.gerenciadorDeContas.Enum.TipoRecebimento;
import com.gerenciadorDeContas.model.ContasReceber;

public class RecebimentoFactory {

    public ICaulculoRecebimento valorRecebimento(ContasReceber contasReceber) {
        if (contasReceber.getTipoRecebimento() == TipoRecebimento.ALUGUEIS) {
            if (contasReceber.getDataDeVencimento().isAfter(contasReceber.getDataDeRecebimento())) {
                return new Adiantado();
            } else if (contasReceber.getDataDeVencimento().isBefore(contasReceber.getDataDeRecebimento())) {
                return new EmAtraso();
            } else if (contasReceber.getDataDeVencimento().equals(contasReceber.getDataDeRecebimento())) {
                return new EmDia();
            }
        }else if (contasReceber.getTipoRecebimento() == TipoRecebimento.FREELANCER) {
                return new Freelancer();
        }else if (contasReceber.getTipoRecebimento() == TipoRecebimento.EMPREGO_CLT) {
            return new EmpregoClt();
        }
            throw new RuntimeException("tipo de recebimento não cadastrado");
    }
}
