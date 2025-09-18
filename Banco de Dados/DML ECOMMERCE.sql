INSERT INTO ecommerce.cliente(nome_completo, email, senha, telefone, data_cadastro) VALUES
('Andre jose', 'andre@hotmail.com', '123456', 11989867745, '2025-09-02 23:18-03'),
('Marcelo bahiano', 'ba@hotmail.com', '1259487aa', 11973466542, '2025-09-01 15:30-03')

INSERT INTO ecommerce.produto(nome_completo, descricao, preco, estoque_disponivel,imagem_url) VALUES
('Notebook Gamer', 'Notebook Dell 16 gb de ram ', 5000.00, 10, ' '),
('Cadeira Gamer', 'Cadeira pra gamers com estofado macio', 2500.00, 5, ''),
('Pc Gamer', 'i7 com 16 gb de ram placa de video gtx420', 7499.99, 1, '')

INSERT INTO ecommerce.pedido(data_pedido, valor_total, status, id_cliente) VALUES
('2025-09-02 10:30-03', 5000.00, 'APROVADO', 1),
('2025-09-02 23:30-03', 9999.99, 'AGUARDANDO', 2)

INSERT INTO ecommerce.pagamento(forma_pagamento,status,data_pagamento,id_pedido) VALUES
('Cartão de Credito', 'Autorizado', '2025-09-02 23:20-03', 1),
('Pix', 'Cancelado', '2025-09-02 23:00-03', 2)

INSERT INTO ecommerce.item_do_pedido(quantidade,id_pedido,id_produto) VALUES
