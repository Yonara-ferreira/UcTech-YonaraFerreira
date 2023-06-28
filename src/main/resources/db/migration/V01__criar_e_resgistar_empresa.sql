CREATE TABLE empresa (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome_fantasia VARCHAR(60) NOT NULL,
	razao_social VARCHAR(120) NOT NULL,
	cnpj VARCHAR(20) NOT NULL,
	telefone_empresa VARCHAR(20),
	endereco VARCHAR(50),
	porte_da_empresa VARCHAR(40)

) ENGINE=InnoDB DEFAULT CHARSET=utf8;