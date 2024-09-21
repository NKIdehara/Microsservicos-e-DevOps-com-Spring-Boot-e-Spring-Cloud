package br.edu.infnet.microsservicos.AT.veiculo_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.microsservicos.AT.veiculo_service.model.Veiculo;
import br.edu.infnet.microsservicos.AT.veiculo_service.service.VeiculoService;


@RestController
@RequestMapping("/veiculo")
public class VeiculoController {
    @Autowired
    private VeiculoService veiculoService;

    @GetMapping("/")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(veiculoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(veiculoService.getById(id).orElse(null));
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody Veiculo veiculo) {
        return ResponseEntity.ok(veiculoService.create(veiculo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Veiculo veiculo) {
        return ResponseEntity.ok(veiculoService.update(id, veiculo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        veiculoService.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Veículo excluído!");
    }
}
