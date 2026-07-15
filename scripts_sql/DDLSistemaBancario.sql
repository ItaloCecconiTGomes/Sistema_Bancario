CREATE TABLE usuarios(
	id_usuario serial PRIMARY KEY,
	cpf bigint UNIQUE NOT NULL,
	nome varchar(20) NOT NULL,
	sobrenome varchar (50) NOT NULL,
	data_nascimento DATE NOT NULL
);

CREATE TABLE contas(
	numero_conta int PRIMARY KEY,
	numero_agencia int NOT NULL,
	conta_ativada boolean NOT NULL,
	corrente float NOT NULL,
	poupanca float NOT NULL,
	id_dono int REFERENCES usuarios(id_usuario)
)