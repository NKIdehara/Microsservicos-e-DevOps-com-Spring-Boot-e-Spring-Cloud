package br.edu.infnet.microsservicos.AT.aeronave_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table("aeronaves")
@Data
@NoArgsConstructor@AllArgsConstructor
public class Aeronave {
    @Id
    private Long id;
    private String fabricante;
    private String modelo;
    private int ano;
}
