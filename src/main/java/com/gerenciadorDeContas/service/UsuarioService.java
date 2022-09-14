package com.gerenciadorDeContas.service;

import com.gerenciadorDeContas.filter.IUsuarioDto;
import com.gerenciadorDeContas.model.Usuario;
import com.gerenciadorDeContas.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    IUsuarioRepository repository;

    public List<IUsuarioDto> buscarTodos(){
        return repository.findAllTodosUsuarios();
    }

    public Optional<Usuario> buscarPorId(Long id){
        return repository.findById(id);
    }

    public Usuario cadastrar(Usuario usuario){
        return repository.save(usuario);
    }

    public Usuario alterar(Usuario usuario){
        return repository.save(usuario);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
