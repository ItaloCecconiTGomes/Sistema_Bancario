CREATE TABLE usuarios(
	id_usuario serial PRIMARY KEY,
	cpf bigint UNIQUE NOT NULL,
	nome varchar(20) NOT NULL,
	sobrenome varchar (50) NOT NULL,
	data_nascimento DATE NOT NULL
)