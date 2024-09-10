package br.edu.infnet.microsservicos.tp3.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import lombok.Setter;

@Table("Fornecedores")
@Getter@Setter
public class Fornecedor {
    @Id
    private Long id;
    private String nome;
    private String endereco;
}
