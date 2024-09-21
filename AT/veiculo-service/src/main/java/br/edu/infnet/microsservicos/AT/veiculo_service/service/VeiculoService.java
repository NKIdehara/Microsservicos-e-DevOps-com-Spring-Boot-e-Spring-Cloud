package br.edu.infnet.microsservicos.AT.veiculo_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.microsservicos.AT.veiculo_service.model.Veiculo;
import br.edu.infnet.microsservicos.AT.veiculo_service.repository.VeiculoRepository;

@Service
public class VeiculoService {
    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> getAll() {
        return veiculoRepository.findAll();
    }

    public Optional<Veiculo> getById(Long id) {
        return veiculoRepository.findById(id);
    }

    public Veiculo create(Veiculo cliente) {
        return veiculoRepository.save(cliente);
    }

    public Veiculo update(Long id, Veiculo veiculo) {
        return veiculoRepository.findById(id).map(update -> {
            update.setFabricante(veiculo.getFabricante());
            update.setModelo(veiculo.getModelo());
            update.setAno(veiculo.getAno());
            update.setCor(veiculo.getCor());
            update.setCambio(veiculo.getCambio());
            return veiculoRepository.save(update);
        }).orElseGet(() -> {
            return null;
        });
    }

    public void delete(Long id) {
        veiculoRepository.deleteById(id);
    }
}