package com.gerenciadorDeContas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cidade")
@Validated
public class Cidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    private String nomeCidade;

    @ManyToOne
    @JoinColumn(name = "estado_id",referencedColumnName = "id")
    private Estado estado;

    @JsonIgnore
    @OneToMany(mappedBy = "cidade",cascade=CascadeType.ALL)
    private List<Endereco> enderecos;
}
