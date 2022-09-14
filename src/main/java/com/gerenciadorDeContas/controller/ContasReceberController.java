package com.gerenciadorDeContas.controller;

import com.gerenciadorDeContas.Enum.TipoRecebimento;
import com.gerenciadorDeContas.model.ContasReceber;
import com.gerenciadorDeContas.service.ContasReceberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/recebimentos")
public class ContasReceberController {

    @Autowired
    ContasReceberService service;

    @GetMapping
    public ResponseEntity<List<ContasReceber>> buscarTodosRecebimentos(){
        return ResponseEntity.ok(service.buscarTodas());
    }

    @GetMapping(value = "/recebimento/{tipoRecebimento}")
    public ResponseEntity<List<ContasReceber>> buscarContaPorTipoRecebimento(@PathVariable TipoRecebimento tipoRecebimento){
        return ResponseEntity.ok(service.buscarTipoRecebimento(tipoRecebimento));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<ContasReceber>> buscarRecebimentoPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ContasReceber> cadastrarRecebimento(@RequestBody ContasReceber conta){
        return ResponseEntity.ok(service.cadastrar(conta));
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<ContasReceber> alterarRecebimento(@RequestBody ContasReceber conta){
        return ResponseEntity.ok(service.alterar(conta));
    }
}
