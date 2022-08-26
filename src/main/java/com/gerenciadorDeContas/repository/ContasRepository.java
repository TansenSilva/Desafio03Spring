package com.gerenciadorDeContas.repository;

import com.gerenciadorDeContas.model.ContasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContasRepository extends JpaRepository<ContasModel,Long> {

}
