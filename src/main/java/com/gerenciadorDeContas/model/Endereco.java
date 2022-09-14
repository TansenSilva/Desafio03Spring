package com.gerenciadorDeContas.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "endereco")
@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo logradouro deve conter um valor")
    private String logradouro;

    @NotBlank(message = "Campo bairro deve conter um valor")
    private String bairro;

    @NotBlank(message = "Campo cep deve conter um valor")
    private String cep;

    private String pontoReferencia;


    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id",referencedColumnName = "id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "cidade_id", referencedColumnName = "id")
    private Cidade cidade;

}
