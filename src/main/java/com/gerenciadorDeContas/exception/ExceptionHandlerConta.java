package com.gerenciadorDeContas.exception;

import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


@ControllerAdvice
public class ExceptionHandlerConta {


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> exceptionHandlerEntradaInvalida(HttpMessageNotReadableException ex){
        return new ResponseEntity<>("Campo digitado inválido"+ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> exceptionHandlerContaNaoCadastrada(NoSuchElementException ex){
        return new ResponseEntity<>("Id de conta não existente no banco de dados.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> exceptionHandlerBuscaPorTipo(MethodArgumentTypeMismatchException ex) {
        Pattern pattern = Pattern.compile("'(.*?)'");
        Matcher matcher = pattern.matcher(ex.getMessage());
        String mensagemTratada = "";
        if(matcher.find() && matcher.find() && matcher.find());
        {
            mensagemTratada = matcher.group(1);
        }
        return new ResponseEntity<>("Filtro de busca não existente, favor informar um válido para realizar a busca."+mensagemTratada, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<String> exceptionIdNaoExistente(EmptyResultDataAccessException ex){
        return new ResponseEntity<>("Id de conta não existente no banco de dados.", HttpStatus.NOT_FOUND);
    }

    //método de validação pra atributo do tipo String
    //caso preencha o atributo nome de forma inválida no momento do cadastro o sistema irá retornar uma mensagem especifica.
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity< Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

}
