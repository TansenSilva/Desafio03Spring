package com.gerenciadorDeContas.service;

import com.gerenciadorDeContas.Enum.Status;
import com.gerenciadorDeContas.Enum.StatusConta;
import com.gerenciadorDeContas.Enum.Tipo;
import com.gerenciadorDeContas.model.BuscaContas;
import com.gerenciadorDeContas.model.ContasModel;
import com.gerenciadorDeContas.model.UpdateStatusConta;
import com.gerenciadorDeContas.repository.ContasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ContasService {

    @Autowired
    private ContasRepository repository;

    public Optional<ContasModel> buscarId(Long id){
        return repository.findById(id);
    }

    public List<ContasModel> buscarStatus(Status status){
        return repository.findByStatus(status);
    }

    public List<ContasModel> buscarTipo(Tipo tipo){
        return repository.findByTipo(tipo);
    }

    public List<BuscaContas> buscarTodos(){
        List<BuscaContas> listaDeContas = new ArrayList<>();
        List<ContasModel> listaModel = repository.findAll();

        for (ContasModel conta: listaModel){
            BuscaContas buscaContas = new BuscaContas();
            buscaContas.setId(conta.getId());
            buscaContas.setNome(conta.getNome());
            buscaContas.setValor(conta.getValor());
            buscaContas.setStatus(conta.getStatus());
            listaDeContas.add(buscaContas);
        }
        return listaDeContas;
    }

    public ContasModel cadastrar(ContasModel conta){
        StatusConta status = new StatusConta();
        conta.setStatus(status.statusConta(conta));

        return repository.save(conta);
    }
    public ContasModel alterar(UpdateStatusConta statusConta,Long id) {

        Optional<ContasModel> conta =  repository.findById(id);
        if (conta.isPresent() && statusConta.getStatus().equals(Status.PAGO)){
            conta.get().setStatus(Status.PAGO);
            LocalDateTime dataAtual = LocalDateTime.now();
            conta.get().setDataDePagamento(dataAtual);
        }
        return repository.save(conta.get());
    }


}
