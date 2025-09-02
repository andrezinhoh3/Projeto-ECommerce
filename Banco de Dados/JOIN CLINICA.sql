-- 1 - Consulta
SELECT nome_completo, telefone FROM ecommerce.cliente;

SELECT nome, idade FROM clinica.paciente;

SELECT * FROM clinica.medico;
--     *    Para trazer todas tabelas

-- JOIN (Juntar)
-- Com o JOIN posso juntar tabelas utilizando a Chave Estrangeira

-- Listar, Data, Valor, Nome do Medico
SELECT 
	cs.data,
	cs.valor,
	med.nome
FROM clinica.consulta AS cs
JOIN 
	clinica.medico AS med
ON cs.id_medico = med.id_medico;