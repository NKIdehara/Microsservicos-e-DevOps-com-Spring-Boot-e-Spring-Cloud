package br.edu.infnet.microsservicos.tp3.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import lombok.Setter;

@Table("Produtos")
@Getter@Setter
public class Produto {
    @Id
    private Long id;
    private String nome;
    private Float preco;
}
