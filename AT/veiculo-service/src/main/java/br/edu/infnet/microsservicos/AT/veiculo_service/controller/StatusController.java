package br.edu.infnet.microsservicos.AT.veiculo_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StatusController {
    @GetMapping("/status")
    public ResponseEntity<?> getStatus() {
        return ResponseEntity.ok("Serviço Ativo!");
    }
}
