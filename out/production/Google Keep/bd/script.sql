CREATE DATABASE bancoJava;

CREATE TABLE notas(
	id_notas INT NOT NULL AUTO_INCREMENT,
	titulo VARCHAR(250),
    conteudo VARCHAR(1000),
	PRIMARY KEY(id_notas)
);
CREATE TABLE usuarios(
	id_usuarios INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(250),
    sobrenome VARCHAR(250),
    email VARCHAR(250),
    senha VARCHAR(250),
    PRIMARY KEY (id_usuarios)
);

CREATE TABLE usuario_nota(
	id_notas INT,
    id_usuarios INT,
    FOREIGN KEY (id_notas) REFERENCES notas(id_notas),
    FOREIGN KEY (id_usuarios) REFERENCES usuarios(id_usuarios),
    PRIMARY KEY (id_notas,id_usuarios)
);

