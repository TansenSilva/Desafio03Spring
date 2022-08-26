package com.gerenciadorDeContas.controller;

import com.gerenciadorDeContas.Enum.Status;
import com.gerenciadorDeContas.Enum.Tipo;
import com.gerenciadorDeContas.filter.BuscarContas;
import com.gerenciadorDeContas.model.ContasModel;
import com.gerenciadorDeContas.model.UpdateStatusConta;
import com.gerenciadorDeContas.service.ContasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public void deletarContaCadastrada(@PathVariable Long id){
        System.out.println("conta deletada");
     service.deletar(id);
    }

    //método de validação pra atributo do tipo String
    //caso preencha o atributo nome de forma inválida no momento do cadastro o sistema irá retornar uma mensagem especifica.
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }


}
