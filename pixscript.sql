CREATE TABLE usuario(
	id		INT NOT NULL AUTO_INCREMENT,
	nome	VARCHAR(45) NOT NULL,
	email	VARCHAR(90) NOT NULL,
	senha	VARCHAR(180) NOT NULL,
PRIMARY KEY(id)
);

CREATE TABLE banco(
	id		INT NOT NULL AUTO_INCREMENT,
	nome	VARCHAR(45) NOT NULL,
	codigo	INT NOT NULL,
PRIMARY KEY(id)
);

CREATE TABLE conta_corrente(
	id			INT NOT NULL AUTO_INCREMENT,
	agencia		INT NOT NULL,
	conta		INT NOT NULL,
	saldo		DECIMAL(10, 2) NOT NULL,
	usuario_id	INT NOT NULL,
	banco_id	INT NOT NULL,
FOREIGN KEY(usuario_id)REFERENCES usuario(id),
FOREIGN KEY(banco_id)REFERENCES banco(id),
PRIMARY KEY(id)
);

CREATE TABLE tipo_chave(
	id		INT NOT NULL AUTO_INCREMENT,
	nome	VARCHAR(45) NOT NULL,
PRIMARY KEY(id)
);

CREATE TABLE chave(
	id					INT NOT NULL AUTO_INCREMENT,
	valor				VARCHAR(90) NOT NULL,
	conta_corrente_id	INT NOT NULL,
	tipo_chave_id		INT NOT NULL,
FOREIGN KEY(conta_corrente_id)REFERENCES conta_corrente(id),
FOREIGN KEY(tipo_chave_id)REFERENCES tipo_chave(id),
PRIMARY KEY(id)
);

CREATE TABLE tipo_transacao(
	id		INT NOT NULL AUTO_INCREMENT,
	nome	VARCHAR(45) NOT NULL,
PRIMARY KEY(id)
);

CREATE TABLE transacao(
	id					INT NOT NULL AUTO_INCREMENT,
	conta_corrente_id	INT NOT NULL,
	tipo_transacao_id	INT NOT NULL,
	valor				DECIMAL(10,2) NOT NULL,
	data_hora			TIMESTAMP NULL DEFAULT NULL,
FOREIGN KEY(conta_corrente_id)REFERENCES conta_corrente(id),
FOREIGN KEY(tipo_transacao_id)REFERENCES tipo_transacao(id),
PRIMARY KEY(id)
);