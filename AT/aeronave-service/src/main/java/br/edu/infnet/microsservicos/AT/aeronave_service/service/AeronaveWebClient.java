package br.edu.infnet.microsservicos.AT.aeronave_service.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.edu.infnet.microsservicos.AT.aeronave_service.model.Aeronave;
import reactor.core.publisher.Flux;

@Service
public class AeronaveWebClient {
    private final WebClient webClient;

    public AeronaveWebClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8081/aeronave/").build();
    }

    public Flux<Aeronave> getAllAeronaves() {
        return webClient.get().retrieve().bodyToFlux(Aeronave.class);
    }
}
