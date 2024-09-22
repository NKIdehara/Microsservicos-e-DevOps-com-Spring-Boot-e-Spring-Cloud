package br.edu.infnet.microsservicos.AT.aeronave_service.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.microsservicos.AT.aeronave_service.model.Aeronave;

@Repository
public interface AeronaveRepository extends R2dbcRepository<Aeronave, Long> {
}
