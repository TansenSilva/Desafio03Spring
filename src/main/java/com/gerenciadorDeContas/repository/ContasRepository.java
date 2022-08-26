package com.gerenciadorDeContas.repository;

import com.gerenciadorDeContas.Enum.Status;
import com.gerenciadorDeContas.Enum.Tipo;
import com.gerenciadorDeContas.filter.BuscarContas;
import com.gerenciadorDeContas.model.ContasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContasRepository extends JpaRepository<ContasModel,Long> {
    List<ContasModel>findByStatus(Status status);

    List<ContasModel>findByTipo(Tipo tipo);

    @Query("select c from ContasModel c")
    List<BuscarContas> findAllTodasContas();

//    boolean existsByNome(String nome);
}
