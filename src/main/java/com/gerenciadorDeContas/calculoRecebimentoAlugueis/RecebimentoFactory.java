package com.gerenciadorDeContas.calculoRecebimentoAlugueis;

import com.gerenciadorDeContas.Enum.RecebimentoAlugueis;
import com.gerenciadorDeContas.Enum.TipoRecebimento;
import com.gerenciadorDeContas.model.ContasReceber;

import static com.gerenciadorDeContas.Enum.RecebimentoAlugueis.*;

public class RecebimentoFactory {

//    public ICaulculoRecebimento valorRecebimento(ContasReceber contasReceber) {
//        if (contasReceber.getTipoRecebimento() == TipoRecebimento.ALUGUEIS) {
//            if (contasReceber.getDataDeVencimento().isAfter(contasReceber.getDataDeRecebimento())) {
//                return new Adiantado();
//            } else if (contasReceber.getDataDeVencimento().isBefore(contasReceber.getDataDeRecebimento())) {
//                return new EmAtraso();
//            } else if (contasReceber.getDataDeVencimento().equals(contasReceber.getDataDeRecebimento())) {
//                return new EmDia();
//            }
//        }else if (contasReceber.getTipoRecebimento() == TipoRecebimento.FREELANCER) {
//                return new Freelancer();
//        }else if (contasReceber.getTipoRecebimento() == TipoRecebimento.EMPREGO_CLT) {
//            return new EmpregoClt();
//        }
//            throw new RuntimeException("tipo de recebimento não cadastrado");
//    }

    public RecebimentoAlugueis recebimento(ContasReceber contasReceber) {

            if (contasReceber.getDataDeVencimento().isAfter(contasReceber.getDataDeRecebimento())) {
                return ADIANTADO;
            } else if (contasReceber.getDataDeVencimento().isBefore(contasReceber.getDataDeRecebimento())) {
                return EM_ATRASO;
            } else if (contasReceber.getDataDeVencimento().equals(contasReceber.getDataDeRecebimento())) {
                return EM_DIA;
            }
        return null;
    }

    public static ICaulculoRecebimento valorRecebimento(RecebimentoAlugueis recebimento, TipoRecebimento tipoRecebimento) {
        if (recebimento == RecebimentoAlugueis.EM_ATRASO) {
            return new EmAtraso();
        } else if (recebimento == RecebimentoAlugueis.EM_DIA) {
            return new EmDia();
        } else if (recebimento == RecebimentoAlugueis.ADIANTADO) {
            return new Adiantado();
        } else if (tipoRecebimento == TipoRecebimento.EMPREGO_CLT) {
            return new EmpregoClt();

        } else if (tipoRecebimento == TipoRecebimento.FREELANCER) {
            return new Freelancer();

        } else {
            return null;
        }
    }

}
