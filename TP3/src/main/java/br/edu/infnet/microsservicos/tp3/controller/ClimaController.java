package br.edu.infnet.microsservicos.tp3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.microsservicos.tp3.model.clima.Clima;
import br.edu.infnet.microsservicos.tp3.service.ClimaService;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/clima")
public class ClimaController {
    @Autowired
    private ClimaService climaService;

    public ClimaController(ClimaService climaService) {
        this.climaService = climaService;
    }

    @GetMapping
    public Flux<Clima> getClimaRJ() {
        return climaService.getClimaRJ();
    }
}
