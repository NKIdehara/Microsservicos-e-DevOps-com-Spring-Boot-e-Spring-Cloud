package br.edu.infnet.microsservicos.tp3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.microsservicos.tp3.model.Produto;
import br.edu.infnet.microsservicos.tp3.service.ProdutoService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public Flux<Produto> getAll() {
        return produtoService.getAll();
    }

    @PostMapping
    public Mono<Produto> add(@RequestBody Produto produto) {
        return produtoService.add(produto);
    }
    
    @PutMapping("/{id}")
    public Mono<Produto> update(@PathVariable Long id, @RequestBody Produto produto) {
        return produtoService.update(id, produto);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Long id) {
        return produtoService.delete(id);
    }
}
