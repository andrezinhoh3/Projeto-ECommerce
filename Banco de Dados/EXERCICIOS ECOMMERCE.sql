-- LISTAGEM SIMPLES
SELECT nome_completo, email FROM ecommerce.cliente;
SELECT nome_completo, email
FROM ecommerce.cliente

-- FILTRAGEM COM CONDICAO NUMERICA
SELECT preco FROM ecommerce.produto;
SELECT preco
FROM ecommerce.produto WHERE preco > 1000;

-- FILTRAGEM COM PADRAO DE TEXTO







-- JUNCAO SIMPLES (JOIN)

SELECT id_pedido FROM ecommerce.pedido;

SELECT nome_completo FROM ecommerce.cliente;

SELECT 
	ped.id_pedido,
	clt.nome_completo
FROM ecommerce.pedido AS ped
JOIN
	ecommerce.cliente AS clt
ON clt.id_cliente = ped.id_cliente;

-- JUNCAO COM FILTRO
SELECT nome_completo FROM ecommerce.produto;

SELECT id_item_do_pedido FROM ecommerce.item_do_pedido;

SELECT
	prd.nome_completo,
	it.id_item_do_pedido
FROM ecommerce.produto AS prd
JOIN
	ecommerce.item_do_pedido AS it
ON prd.id_produto = it.id_produto WHERE id_pedido = 1