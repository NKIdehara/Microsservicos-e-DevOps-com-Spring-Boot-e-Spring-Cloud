package br.edu.infnet.microsservicos.AT.aeronave_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.microsservicos.AT.aeronave_service.model.Aeronave;
import br.edu.infnet.microsservicos.AT.aeronave_service.repository.AeronaveRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AeronaveService {
    @Autowired
    private AeronaveRepository aeronaveRepository;

    public Flux<Aeronave> getAll() {
        return aeronaveRepository.findAll();
    }

    public Mono<Aeronave> create(Aeronave aeronave) {
        return aeronaveRepository.save(aeronave);
    }
}
