package com.gerenciadorDeContas.controller;

import com.gerenciadorDeContas.Enum.RecebimentoAlugueis;
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
@RequestMapping(value = "/contasReceber")
public class ContasReceberController {
    @Autowired
    ContasReceberService service;

    @GetMapping
    public ResponseEntity<List<ContasReceber>> buscarTodosRecebimentos(){
        return ResponseEntity.ok(service.buscarTodas());
    }
    @GetMapping(value = "/recebimentos/{tipoRecebimento}")
    public ResponseEntity<List<ContasReceber>> buscarContaPorTipoRecebimento(@PathVariable TipoRecebimento tipoRecebimento){
        return ResponseEntity.ok(service.buscarTipoRecebimento(tipoRecebimento));
    }
    @GetMapping(value = "/alugueis/{RecebimentoAlugeis}")
    public ResponseEntity<List<ContasReceber>> buscarContaPorRecebimentoAlugueis(@PathVariable RecebimentoAlugueis recebimentoAlugueis){
        return ResponseEntity.ok(service.buscarRecebimento(recebimentoAlugueis));
    }

    @GetMapping(path = "/datadevencimento/{dataDeVencimento}")
    public ResponseEntity<List<ContasReceber>> buscarContaPorDataDeVencimento(@PathVariable String dataDeVencimento) {
        return ResponseEntity.ok(service.buscarPorVencimento(dataDeVencimento));
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
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletarRecebimento(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deletado");
    }
}
