package com.gerenciadorDeContas.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cidade")
@Entity
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "o campo deve conter um nome")
    private String nomeCidade;

    @ManyToOne
    @JoinColumn(name = "estado_id",referencedColumnName = "id")
    private Estado estado;

    @JsonIgnore
    @OneToMany(mappedBy = "cidade")
    private List<Endereco> enderecos;
}
