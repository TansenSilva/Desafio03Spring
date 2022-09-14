package com.gerenciadorDeContas.controller;

import com.gerenciadorDeContas.model.Cidade;
import com.gerenciadorDeContas.model.Endereco;
import com.gerenciadorDeContas.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoController {

    @Autowired
    EnderecoService service;

    @GetMapping
    public ResponseEntity<List<Endereco>> buscarTodosEnderecos(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Endereco>> buscarEnderecoPorId(@PathVariable Long id){
        return  ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Endereco> cadastrarEndereco(@RequestBody Endereco endereco){
        return ResponseEntity.ok(service.cadastrar(endereco));
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Endereco> alterarEndereco(@RequestBody Endereco endereco){
        return ResponseEntity.ok(service.alterar(endereco));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletarEndereco(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deletado");
    }
}
