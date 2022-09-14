package com.gerenciadorDeContas.repository;

import com.gerenciadorDeContas.Enum.Tipo;
import com.gerenciadorDeContas.Enum.TipoRecebimento;
import com.gerenciadorDeContas.model.ContasReceber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IContasReceberRepository extends JpaRepository<ContasReceber,Long> {

    List<ContasReceber> findByTipoRecebimento(TipoRecebimento tipoRecebimento);
}