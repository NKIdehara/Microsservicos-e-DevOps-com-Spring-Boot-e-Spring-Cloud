package br.edu.infnet.microsservicos.tp3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.microsservicos.tp3.model.Produto;
import br.edu.infnet.microsservicos.tp3.repository.ProdutoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Flux<Produto> getAll() {
        return produtoRepository.findAll();
    }

    public Mono<Produto> add(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Mono<Produto> update(Long id, Produto produto) {
        return produtoRepository.findById(id).flatMap(update -> {
            update.setNome(produto.getNome());
            update.setPreco(produto.getPreco());
            return produtoRepository.save(update);
        });
    }

    public Mono<Void> delete(Long id) {
        return produtoRepository.deleteById(id);
    }
}
