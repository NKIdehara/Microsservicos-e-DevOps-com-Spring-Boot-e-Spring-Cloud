package br.edu.infnet.microsservicos.tp3.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.microsservicos.tp3.model.Fornecedor;

@Repository
public interface FornecedorRepository extends R2dbcRepository<Fornecedor, Long> {
}
