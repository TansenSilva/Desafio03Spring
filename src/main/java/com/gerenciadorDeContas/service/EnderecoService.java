package com.gerenciadorDeContas.service;

import com.gerenciadorDeContas.model.Endereco;
import com.gerenciadorDeContas.repository.IEnderecoRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    IEnderecoRepositoy repository;

    public List<Endereco> buscarTodos(){
        return repository.findAll();
    }

    public Optional<Endereco> buscarPorId(Long id){
        return repository.findById(id);
    }

    public Endereco cadastrar(Endereco endereco){
        return repository.save(endereco);
    }

    public Endereco alterar(Endereco endereco){
        return repository.save(endereco);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
