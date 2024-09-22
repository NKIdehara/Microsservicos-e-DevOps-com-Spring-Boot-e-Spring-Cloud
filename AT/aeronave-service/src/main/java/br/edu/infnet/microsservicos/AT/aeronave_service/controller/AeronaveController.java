package br.edu.infnet.microsservicos.AT.aeronave_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.microsservicos.AT.aeronave_service.model.Aeronave;
import br.edu.infnet.microsservicos.AT.aeronave_service.service.AeronaveService;
import br.edu.infnet.microsservicos.AT.aeronave_service.service.AeronaveWebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/aeronave")
public class AeronaveController {
    @Autowired
    private AeronaveService aeronaveService;

    private final AeronaveWebClient aeronaveWebClient;

    public AeronaveController(AeronaveWebClient aeronaveWebClient) {
        this.aeronaveWebClient = aeronaveWebClient;
    }

    @GetMapping("/")
    public Flux<Aeronave> getAll() {
        return aeronaveService.getAll();
    }

    @GetMapping("/webclient")
    public Flux<Aeronave> getAllAeronaves() {
        return aeronaveWebClient.getAllAeronaves();
    }

    @PostMapping("/")
    public Mono<Aeronave> create(@RequestBody Aeronave aeronave) {
        return aeronaveService.create(aeronave);
    }
}