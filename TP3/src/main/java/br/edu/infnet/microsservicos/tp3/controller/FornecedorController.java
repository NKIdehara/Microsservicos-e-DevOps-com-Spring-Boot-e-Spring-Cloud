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

import br.edu.infnet.microsservicos.tp3.model.Fornecedor;
import br.edu.infnet.microsservicos.tp3.service.FornecedorService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {
    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public Flux<Fornecedor> getAll() {
        return fornecedorService.getAll();
    }

    @PostMapping
    public Mono<Fornecedor> add(@RequestBody Fornecedor fornecedor) {
        return fornecedorService.add(fornecedor);
    }
    
    @PutMapping("/{id}")
    public Mono<Fornecedor> update(@PathVariable Long id, @RequestBody Fornecedor fornecedor) {
        return fornecedorService.update(id, fornecedor);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Long id) {
        return fornecedorService.delete(id);
    }
}
