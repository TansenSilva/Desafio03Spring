package com.gerenciadorDeContas.service;

import com.gerenciadorDeContas.model.Cidade;
import com.gerenciadorDeContas.model.Endereco;
import com.gerenciadorDeContas.repository.ICidadeRepository;
import com.gerenciadorDeContas.repository.IEnderecoRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    ICidadeRepository repository;

    public List<Cidade> buscarTodos(){
        return repository.findAll();
    }

    public Optional<Cidade> buscarPorId(Long id){
        return repository.findById(id);
    }

    public Cidade cadastrar(Cidade cidade){
        return repository.save(cidade);
    }

    public Cidade alterar(Cidade cidade){
        return repository.save(cidade);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
