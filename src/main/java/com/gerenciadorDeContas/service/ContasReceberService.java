package com.gerenciadorDeContas.service;

import com.gerenciadorDeContas.Enum.RecebimentoAlugueis;
import com.gerenciadorDeContas.Enum.TipoRecebimento;
import com.gerenciadorDeContas.calculoRecebimentoAlugueis.RecebimentoFactory;
import com.gerenciadorDeContas.model.ContasReceber;
import com.gerenciadorDeContas.repository.IContasReceberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ContasReceberService {

    @Autowired
    IContasReceberRepository repository;

    public List<ContasReceber> buscarTodas(){
        return repository.findAll();
    }

    public List<ContasReceber> buscarTipoRecebimento(TipoRecebimento tipoRecebimento){
        return repository.findByTipoRecebimento(tipoRecebimento);
    }

    public List<ContasReceber> buscarPorVencimento(String dataDeVencimento) {
        LocalDate localDate = LocalDate.parse(dataDeVencimento);
        return repository.findByDataDeVencimento(localDate);
    }

    public List<ContasReceber> buscarRecebimento(RecebimentoAlugueis recebimento){
        return repository.findByRecebimentos(recebimento);
    }

    public Optional<ContasReceber> buscarPorId(Long id){
        return repository.findById(id);
    }
    public ContasReceber cadastrar(ContasReceber conta){
//        RecebimentoFactory recebimento = new RecebimentoFactory();
//        BigDecimal total = recebimento.valorRecebimento(conta).calculoRecebimento(conta);
//        conta.setValorRecebimento(total);
//        return repository.save(conta);
        RecebimentoFactory factory = new RecebimentoFactory();
        RecebimentoAlugueis recebimento = factory.recebimento(conta);
        conta.setRecebimentos(recebimento);

        BigDecimal valor = (BigDecimal) factory.valorRecebimento(conta.getRecebimentos(),conta.getTipoRecebimento()).calculoRecebimento(conta);
        conta.setValorRecebimento(valor);

        return repository.save(conta);
    }

    public ContasReceber alterar(ContasReceber conta){

        RecebimentoFactory factory = new RecebimentoFactory();
        RecebimentoAlugueis recebimento = factory.recebimento(conta);
        conta.setRecebimentos(recebimento);

        BigDecimal valor = (BigDecimal) factory.valorRecebimento(conta.getRecebimentos(),conta.getTipoRecebimento()).calculoRecebimento(conta);
        conta.setValorRecebimento(valor);

        return repository.save(conta);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
