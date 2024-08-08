package br.edu.infnet.microservicos.tp1_client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.microservicos.tp1_client.model.Cliente;
import br.edu.infnet.microservicos.tp1_client.service.ClienteService;


@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/")
    public List<Cliente> getAll() {
        return clienteService.getAll();
    }
}
