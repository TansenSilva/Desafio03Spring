package com.gerenciadorDeContas.model;

import com.gerenciadorDeContas.Enum.Status;
import com.gerenciadorDeContas.Enum.Tipo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
    private String nome;

    @Column(length = 20,nullable = false)
    private double valor;

    @Enumerated(value = EnumType.STRING)
    @Column(length = 50,nullable = false)
    private Tipo tipo;

    @Column(length = 20,nullable = false)
    private LocalDate dataDeVencimento;

    @Column(length = 20)
    private LocalDateTime dataDePagamento;

    @Enumerated(value = EnumType.STRING)
    @Column(length = 20,nullable = false)
    private Status status;
}
