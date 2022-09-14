package com.gerenciadorDeContas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gerenciadorDeContas.Enum.RecebimentoAlugueis;
import com.gerenciadorDeContas.Enum.TipoRecebimento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Validated
@Table(name = "contas_receber")
public class ContasReceber implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    private String recebimento;

    @NotNull
    private BigDecimal valorRecebimento;

    @Enumerated(value = EnumType.STRING)
    private TipoRecebimento tipoRecebimento;

    private LocalDate dataDeVencimento;

    private LocalDate dataDeRecebimento = LocalDate.now();

    private String status;

    @Enumerated(value = EnumType.STRING)
    private RecebimentoAlugueis recebimentos;

    @ManyToOne
    @JoinColumn(name = "usuario_id",referencedColumnName = "id")
    private Usuario usuario;
}
