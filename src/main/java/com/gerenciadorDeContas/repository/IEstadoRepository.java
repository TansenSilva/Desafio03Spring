package com.gerenciadorDeContas.repository;

import com.gerenciadorDeContas.model.ContasReceber;
import com.gerenciadorDeContas.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstadoRepository extends JpaRepository<Estado,Long> {
}
