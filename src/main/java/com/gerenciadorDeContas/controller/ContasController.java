package com.gerenciadorDeContas.controller;

import com.gerenciadorDeContas.Enum.Status;
import com.gerenciadorDeContas.Enum.Tipo;
import com.gerenciadorDeContas.filter.BuscarContas;
import com.gerenciadorDeContas.model.ContasModel;
import com.gerenciadorDeContas.model.UpdateStatusConta;
import com.gerenciadorDeContas.service.ContasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping(path = "/contas/status/{status}")
    public ResponseEntity<List<ContasModel>> buscarContaPorStatus(@PathVariable Status status) {
        return ResponseEntity.ok(service.buscarStatus(status));
    }

    @GetMapping(path = "/contas/tipo/{tipo}")
    public ResponseEntity<List<ContasModel>> buscarContaPorTipo(@PathVariable Tipo tipo) {
        return ResponseEntity.ok(service.buscarTipo(tipo));
    }

    @GetMapping(path = "/contas")
    public ResponseEntity<List<BuscarContas>>buscarTodasContas(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @PostMapping(path = "/contas")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ContasModel> cadastrarConta(@RequestBody @Valid ContasModel conta){
        return ResponseEntity.ok(service.cadastrar(conta));
    }

    @PutMapping(path = "/contas/{id}")
    public ResponseEntity<ContasModel> alterarConta(@RequestBody UpdateStatusConta statusConta,@PathVariable Long id) {
        return ResponseEntity.ok(service.alterar(statusConta,id));
    }

    @DeleteMapping(path = "/contas/{id}")
    public ResponseEntity<String> deletarContaCadastrada(@PathVariable Long id){
     service.deletar(id);
     return ResponseEntity.status(HttpStatus.NO_CONTENT).contentType(MediaType.TEXT_PLAIN).body("Deletado com sucesso");
    }




}
