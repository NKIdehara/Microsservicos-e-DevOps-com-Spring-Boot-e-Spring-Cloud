package br.edu.infnet.microsservicos.tp3.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import br.edu.infnet.microsservicos.tp3.model.Produto;

public interface ProdutoRepository extends R2dbcRepository<Produto, Long> {
}
