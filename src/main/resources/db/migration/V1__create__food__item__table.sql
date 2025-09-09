CREATE TABLE tb_food_item(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255),
    categoria VARCHAR(50),
    quantidade INT NOT NULL,
    validade TIMESTAMP
);