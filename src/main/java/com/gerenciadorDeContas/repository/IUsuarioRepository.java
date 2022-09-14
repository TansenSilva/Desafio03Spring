package com.gerenciadorDeContas.repository;

import com.gerenciadorDeContas.filter.BuscarContas;
import com.gerenciadorDeContas.filter.IUsuarioDto;
import com.gerenciadorDeContas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Long> {

    @Query("select u from Usuario u")
    List<IUsuarioDto> findAllTodosUsuarios();

}
