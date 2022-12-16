CREATE DATABASE bancoJava;

CREATE TABLE usuarios(
	id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR (250),
    sobrenome VARCHAR(250),
    email VARCHAR(250),
    senha VARCHAR(250),
    PRIMARY KEY(id)
);
-- adicionando uma variavel booleana dentro do banco, para poder fazer uma lixeira, caso seja 1,é visivel pro usuário
-- se for zero está dentro da lixeira e só possível do usuario ver, caso entre na lixeira.
CREATE TABLE nota(
	id_nota INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    id_usuario INT NOT NULL,
    titulo VARCHAR(45),
    conteudo VARCHAR(1000),
    visivel BIT NOT NULL  DEFAULT 1,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);