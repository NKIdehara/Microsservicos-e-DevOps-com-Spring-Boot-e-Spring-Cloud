package br.edu.infnet.microservicos.tp1_client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.microservicos.tp1_client.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
}
