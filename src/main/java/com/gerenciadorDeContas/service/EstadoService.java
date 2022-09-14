package com.gerenciadorDeContas.service;

import com.gerenciadorDeContas.model.Endereco;
import com.gerenciadorDeContas.model.Estado;
import com.gerenciadorDeContas.repository.IEnderecoRepositoy;
import com.gerenciadorDeContas.repository.IEstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    IEstadoRepository repository;

    public List<Estado> buscarTodos(){
        return repository.findAll();
    }

    public Optional<Estado> buscarPorId(Long id){
        return repository.findById(id);
    }

    public Estado cadastrar(Estado estado){
        return repository.save(estado);
    }

    public Estado alterar(Estado estado){
        return repository.save(estado);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
