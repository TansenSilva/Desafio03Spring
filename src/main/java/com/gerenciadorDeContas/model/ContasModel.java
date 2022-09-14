package com.gerenciadorDeContas.model;

import com.gerenciadorDeContas.Enum.Status;
import com.gerenciadorDeContas.Enum.Tipo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Validated
@Table(name = "gerenciador_de_contas")
public class ContasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    @NotBlank(message = "Campo nome deve conter um valor")
    private String nome;

    @Column(length = 20)
    @Min(value = 1)
    private double valor;

    @Column(length = 50)
    @Enumerated(value = EnumType.STRING)
    private Tipo tipo;

    @Column(length = 20)
    @NotNull
    private LocalDate dataDeVencimento;

    @Column(length = 20)
    private LocalDateTime dataDePagamento;

    @Column(length = 20,nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Status status;
}
