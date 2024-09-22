package br.edu.infnet.microsservicos.AT.aeronave_service;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.edu.infnet.microsservicos.AT.aeronave_service.controller.AeronaveController;
import br.edu.infnet.microsservicos.AT.aeronave_service.model.Aeronave;
import br.edu.infnet.microsservicos.AT.aeronave_service.repository.AeronaveRepository;
import br.edu.infnet.microsservicos.AT.aeronave_service.service.AeronaveService;
import br.edu.infnet.microsservicos.AT.aeronave_service.service.AeronaveWebClient;
import reactor.core.publisher.Flux;

@WebFluxTest(AeronaveController.class)
public class AeronaveTest {
    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private AeronaveRepository aeronaveRepository;

    @MockBean
    private AeronaveService aeronaveService;

    @MockBean
    private AeronaveWebClient aeronaveWebClient;

    private Aeronave aeronave;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        aeronave = new Aeronave(1L, "Embraer", "E195", 2023);
    }

    @Test
    public void testGetAllAeronaves() {
        doReturn(Flux.just(aeronave)).when(aeronaveService).getAll();

        webTestClient.get().uri("/aeronave/")
            .exchange()
            .expectStatus().isOk()
            .expectBodyList(Aeronave.class)
            .hasSize(1)
            .contains(aeronave);
    }
}
