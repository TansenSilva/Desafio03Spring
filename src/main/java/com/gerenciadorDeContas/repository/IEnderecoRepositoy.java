package com.gerenciadorDeContas.repository;

import com.gerenciadorDeContas.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEnderecoRepositoy extends JpaRepository<Endereco,Long> {
}
