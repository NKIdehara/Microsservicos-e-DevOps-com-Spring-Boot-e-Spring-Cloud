package br.edu.infnet.microsservicos.AT.veiculo_service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.edu.infnet.microsservicos.AT.veiculo_service.model.Veiculo;
import br.edu.infnet.microsservicos.AT.veiculo_service.service.VeiculoService;

@SpringBootTest
@AutoConfigureMockMvc
public class VeiculoTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private VeiculoService veiculoService;

    @Test
    void testStatus() throws Exception {
        this.mockMvc.perform(get("/status")).andExpect(status().isOk());
    }

    @Test
    void testGet() throws Exception {
        this.mockMvc.perform(get("/veiculo/")).andExpect(status().isOk());
    }

    @Test
    void testPost() throws Exception {
        var veiculo = Veiculo.builder()
                        .fabricante("Fabricante 1")
                        .modelo("Modelo 1")
                        .ano(2024)
                        .cor("Azul")
                        .cambio("Manual")
                        .build();
        mockMvc.perform(MockMvcRequestBuilders
                .post("/veiculo/")
                .content(objectMapper.writeValueAsString(veiculo))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testPut() throws Exception {
        var veiculo1 = Veiculo.builder()
                        .fabricante("Fabricante 1")
                        .modelo("Modelo 1")
                        .ano(2024)
                        .cor("Azul")
                        .cambio("Manual")
                        .build();
        var veiculo2 = Veiculo.builder()
                        .fabricante("Fabricante 2")
                        .modelo("Modelo 2")
                        .ano(2023)
                        .cor("Preto")
                        .cambio("Automatico")
                        .build();

        Long id = veiculoService.create(veiculo1).getId();
        mockMvc.perform(MockMvcRequestBuilders
                .put("/veiculo/" + id)
                .content(objectMapper.writeValueAsString(veiculo2))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testDelete() throws Exception {
        var veiculo = Veiculo.builder()
                        .fabricante("Fabricante 1")
                        .modelo("Modelo 1")
                        .ano(2024)
                        .cor("Azul")
                        .cambio("Manual")
                        .build();
        Long id = veiculoService.create(veiculo).getId();
        mockMvc.perform(MockMvcRequestBuilders.delete("/veiculo/" + id)).andExpect(status().isAccepted());
    }
}
