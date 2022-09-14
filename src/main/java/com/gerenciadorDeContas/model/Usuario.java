package com.gerenciadorDeContas.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario")
@Entity
@Validated
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo nomeUsuário deve conter um valor")
    private String nomeUsuario;

    @NotNull
    private Date dataNascimento;

    @Email
    private String email;

    @CPF
    private String cpf;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<ContasReceber> contas;

    @JsonManagedReference
    @OneToMany(mappedBy = "usuario",fetch = FetchType.LAZY)
    private List<Endereco> enderecos;

}
