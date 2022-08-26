package com.gerenciadorDeContas.model;

import com.gerenciadorDeContas.Enum.Status;
import com.gerenciadorDeContas.Enum.Tipo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "gerenciador_de_contas")
public class ContasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    @NotBlank(message = "Campo nome deve conter um valor")
    private String nome;

    @Column(length = 20)
    private double valor;

    @Column(length = 50)
    @Enumerated(value = EnumType.STRING)
    private Tipo tipo;

    @Column(length = 20)
    private LocalDate dataDeVencimento;

    @Column(length = 20)
    private LocalDateTime dataDePagamento;

    @Column(length = 20,nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Status status;
}
