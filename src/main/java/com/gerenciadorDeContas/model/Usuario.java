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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Validated
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nomeUsuario;

    private Date dataNascimento;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @CPF
    private String cpf;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL)
    private List<ContasReceber> contas;

    @JsonManagedReference
    @OneToMany(mappedBy = "usuario",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Endereco> enderecos;

}
