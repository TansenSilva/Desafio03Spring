package com.gerenciadorDeContas.model;

import com.gerenciadorDeContas.Enum.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BuscaContas {

    private Long id;
    private String nome;
    private double valor;
    private Status status;
}
