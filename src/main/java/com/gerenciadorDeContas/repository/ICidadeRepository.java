package com.gerenciadorDeContas.repository;

import com.gerenciadorDeContas.model.Cidade;
import com.gerenciadorDeContas.model.ContasReceber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICidadeRepository extends JpaRepository<Cidade,Long> {
}
