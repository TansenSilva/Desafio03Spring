package com.gerenciadorDeContas.controller;

import com.gerenciadorDeContas.model.Cidade;
import com.gerenciadorDeContas.model.Estado;
import com.gerenciadorDeContas.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/estado")
public class EstadoController {

    @Autowired
    EstadoService service;

    @GetMapping
    public ResponseEntity<List<Estado>> buscarTodosEstados(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Estado>> buscarEstadoPorId(@PathVariable Long id){
        return  ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Estado> cadastrarEstado(@RequestBody Estado estado){
        return ResponseEntity.ok(service.cadastrar(estado));
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Estado> alterarEstado(@RequestBody Estado estado){
        return ResponseEntity.ok(service.alterar(estado));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletarEstado(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deletado");
    }
}
