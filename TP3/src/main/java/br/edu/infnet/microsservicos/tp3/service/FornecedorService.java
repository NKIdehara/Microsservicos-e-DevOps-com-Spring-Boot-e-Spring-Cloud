package br.edu.infnet.microsservicos.tp3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.microsservicos.tp3.model.Fornecedor;
import br.edu.infnet.microsservicos.tp3.repository.FornecedorRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Flux<Fornecedor> getAll() {
        return fornecedorRepository.findAll();
    }

    public Mono<Fornecedor> add(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public Mono<Fornecedor> update(Long id, Fornecedor fornecedor) {
        return fornecedorRepository.findById(id).flatMap(update -> {
            update.setNome(fornecedor.getNome());
            update.setEndereco(fornecedor.getEndereco());
            return fornecedorRepository.save(update);
        });
    }

    public Mono<Void> delete(Long id) {
        return fornecedorRepository.deleteById(id);
    }
}
