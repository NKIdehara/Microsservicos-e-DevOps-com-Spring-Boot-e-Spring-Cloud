CREATE TABLE IF NOT EXISTS Fornecedores (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255),
    endereco VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS Produtos (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255),
    preco DECIMAL(10, 2)
);