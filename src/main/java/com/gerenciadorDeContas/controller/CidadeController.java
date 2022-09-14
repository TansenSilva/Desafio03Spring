package com.gerenciadorDeContas.controller;

import com.gerenciadorDeContas.model.Cidade;
import com.gerenciadorDeContas.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cidade")
public class CidadeController {

    @Autowired
    CidadeService service;

    @GetMapping
    public ResponseEntity<List<Cidade>> buscarTodasCidades(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Cidade>> buscarCidadePorId(@PathVariable Long id){
        return  ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Cidade> cadastrarCidade(@RequestBody Cidade cidade){
        return ResponseEntity.ok(service.cadastrar(cidade));
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Cidade> alterarCidade(@RequestBody Cidade cidade){
        return ResponseEntity.ok(service.alterar(cidade));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletarCidade(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deletado");
    }
}
