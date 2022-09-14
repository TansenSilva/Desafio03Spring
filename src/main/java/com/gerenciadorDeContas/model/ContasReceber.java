package com.gerenciadorDeContas.model;

import com.gerenciadorDeContas.Enum.TipoRecebimento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contas_receber")
@Entity
public class ContasReceber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo recebimento deve conter um valor")
    private String recebimento;

    private BigDecimal valorRecebimento;

    @Enumerated(value = EnumType.STRING)
    private TipoRecebimento tipoRecebimento;

    @NotNull
    private LocalDate dataDeVencimento;

    private LocalDate dataDeRecebimento = LocalDate.now();

    private String status;

    @ManyToOne
    @JoinColumn(name = "usuario_id",referencedColumnName = "id")
    private Usuario usuario;
}
