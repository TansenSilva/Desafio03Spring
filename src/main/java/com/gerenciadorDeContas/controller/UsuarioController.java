package com.gerenciadorDeContas.controller;

import com.gerenciadorDeContas.filter.IUsuarioDto;
import com.gerenciadorDeContas.model.Usuario;
import com.gerenciadorDeContas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @GetMapping
    public ResponseEntity<List<IUsuarioDto>> buscarTodosUsuarios(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Usuario>> buscarUsuarioPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.ok(service.cadastrar(usuario));
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Usuario> alterarUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.ok(service.alterar(usuario));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletarUsuario(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deletado");
    }
}
