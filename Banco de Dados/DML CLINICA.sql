-- DML ( Data Manipulation Language)
-- INSERT (Cadastrar)
-- UPDATE (Atualizar)
-- DELETE (Apaga)

-- OPCIONAL
-- SET search_path TO <SCHEMA>;

-- INSERT INTO <SCHEMA>.<TABELA> (<COLUNAS>) VALUES
INSERT INTO clinica.medico(nome, especialidade, crm) VALUES
('André', 'Ortopedia', '15741368'),
('Matheus', 'Fisioterapeuta', '7415689'),
('Maria', 'Cardiologista', '003154975')

-- DQL (Data Query Language) - Linguagem de Consulta de Dados
-- SELECT
-- SELECT <QUAIS_COLUNAS> FROM <SCHEMA>.<TABELA>
SELECT * FROM clinica.medico;

INSERT INTO clinica.paciente(nome, idade, data_nascimento) VALUES
('Francisca', 26, '1999-05-24'),
('Isabel', 45, '1984-07-01'),
('Mario', 25, '2000-02-29')

SELECT * FROM clinica.paciente

INSERT INTO clinica.clinica(nome, descricao, endereco) VALUES
('NotreDame Intermedica', 'Hospital do abc', 'Av Sao bernardo 15471'),
('Clinica Sao Caetano', 'A Melhor Clinica de Ortopedia do abc', 'Rua Niteroi 301')

SELECT * FROM clinica.clinica

INSERT INTO clinica.consulta(data, valor, id_medico, id_clinica, id_paciente) VALUES
('2025-08-27 09:33:00-03', 258.59, 3, 1, 2 ),
('2025-07-25 20:35:09-03', 195.05, 2, 2, 1)

SELECT * FROM clinica.consulta;

-- UPDATE
UPDATE clinica.consulta SET valor = 250.50 WHERE id_consulta = 1;

UPDATE clinica.consulta SET valor = 550.00 WHERE valor > 500 AND < 1000;
--                                                           OR

-- DELETE 
DELETE FROM clinica.medico WHERE id_medico = 1;



