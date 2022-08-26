package com.gerenciadorDeContas.controller;

import com.gerenciadorDeContas.model.BuscaContas;
import com.gerenciadorDeContas.model.ContasModel;
import com.gerenciadorDeContas.model.UpdateStatusConta;
import com.gerenciadorDeContas.service.ContasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ContasController {

    @Autowired
    private ContasService service;

    @GetMapping(path = "/contas/{id}")
    public Optional<ContasModel> buscarPorId(@PathVariable Long id){
        return service.buscarId(id);
    }

    @GetMapping(path = "/contas")
    public ResponseEntity<List<BuscaContas>>buscarTodasContas(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @PostMapping(path = "/contas")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ContasModel> cadastrarConta(@RequestBody ContasModel conta){
        return ResponseEntity.ok(service.cadastrar(conta));
    }

    @PutMapping(path = "/contas/{id}")
    public ResponseEntity<ContasModel> alterarConta(@RequestBody UpdateStatusConta statusConta,@PathVariable Long id) {
        return ResponseEntity.ok(service.alterar(statusConta,id));
    }

}
