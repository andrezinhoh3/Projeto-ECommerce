-- é um comentario!
/*
é um comentario de multiplas linhas!
*/

SET search_path TO ecommerce;

-- DDL - Criar - Create (Schema, Tabela)
CREATE SCHEMA ecommerce IF NOT EXISTS;

-- CREATE TABLE <SCHEMA>.<NOME_DA_TABELA>
CREATE TABLE ecommerce.cliente (
	-- Informar Colunas
	-- NOME_DA_COLUNA TIPO_DE_DADO
	-- PRIMARY KEY - CHAVE PRIMARIA
	-- GENERATED ALWAYS AS IDENTITY - A CHAVE PRIMARIA É CRIADA AUTOMATICAMENTE
	id_cliente INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	nome_completo TEXT NOT NULL,
	email TEXT NOT NULL,
	senha TEXT NOT NULL,
	telefone VARCHAR(11) NOT NULL,
	data_cadastro TIMESTAMPTZ NOT NULL
);

CREATE TABLE ecommerce.produto (
	id_produto INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	nome_completo TEXT NOT NULL,
	descricao TEXT,
	preco NUMERIC(10,4) NOT NULL,
	estoque_disponivel INT NOT NULL,
	imagem_url TEXT NOT NULL
);

CREATE TABLE ecommerce.pedido (
	id_pedido INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	data_pedido TIMESTAMPTZ NOT NULL,
	valor_total NUMERIC(10,4) NOT NULL,
	status TEXT,
	id_cliente INT NOT NULL REFERENCES ecommerce.cliente(id_cliente)
);

CREATE TABLE ecommerce.pagamento (
	id_pagamento INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	forma_pagamento TEXT NOT NULL,
	status TEXT NOT NULL,
	data_pagamento DATE NOT NULL,
	-- Maneira Abreviada
	id_pedido INT NOT NULL REFERENCES ecommerce.pedido(id_pedido)
);

CREATE TABLE ecommerce.item_do_pedido (
	id_item_do_pedido INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	quantidade INT NOT NULL,
	id_pedido INT NOT NULL REFERENCES ecommerce.pedido(id_pedido),
	id_produto INT NOT NULL REFERENCES ecommerce.produto(id_produto)
);

ALTER TABLE ecommerce.


-- Apagar Tabela - DROP
/*
DROP TABLE IF EXISTS ecommerce.cliente;
DROP TABLE IF EXISTS ecommerce.produto;
DROP TABLE IF EXISTS ecommerce.pedido;
DROP TABLE IF EXISTS ecommerce.pagamento;
DROP TABLE IF EXISTS ecommerce.item_do_pedido;
*/