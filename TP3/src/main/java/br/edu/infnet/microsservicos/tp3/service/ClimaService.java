package br.edu.infnet.microsservicos.tp3.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.edu.infnet.microsservicos.tp3.model.clima.Clima;
import reactor.core.publisher.Flux;

@Service
public class ClimaService {
    private final WebClient webClient;

    public ClimaService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.open-meteo.com/v1/forecast?latitude=22.90&longitude=43.17&current=temperature").build();
    }

    public Flux<Clima> getClimaRJ() {
        return webClient.get().retrieve().bodyToFlux(Clima.class);
    }
}
