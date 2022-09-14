package com.gerenciadorDeContas.filter;

import java.util.Date;

public interface IUsuarioDto {

    Long getId();

    String getNomeUsuario();

    Date getDataNascimento();

    String getEmail();
}
