package br.edu.infnet.microservicos.tp1_client.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.microservicos.tp1_client.model.Cliente;
import br.edu.infnet.microservicos.tp1_client.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> getById(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente create(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void delete(Cliente cliente) {
        clienteRepository.delete(cliente);
    }
}
