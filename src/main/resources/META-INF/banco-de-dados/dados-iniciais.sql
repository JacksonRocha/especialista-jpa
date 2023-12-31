insert into produto (id, nome, preco, data_criacao, descricao) values (1, 'Kindle', 799.0, date_sub(sysdate(), interval 1 day ),'Conheça o novo Kindle, agora com que permite que você leia em ambientes abertos ou fechados, a qualquer hora do dia');
insert into produto (id, nome, preco, data_criacao, descricao) values (3, 'Câmera GoPro Hero 7', 1400.0, date_sub(sysdate(), interval 1 day ),'Desempenho 2X melhor');
insert into produto (id, nome, preco, data_criacao, descricao) values (4, 'Câmera Canon 80D', 3500.0, sysdate(), 'O melhor ajuste de foco.');

insert into cliente (id, nome, cpf) values (1, 'Fernando Medeiros', '123456789101');
insert into cliente (id, nome, cpf) values (2, 'Marcos Mariano', '98765432876');

insert into cliente_detalhe (cliente_id, sexo, data_nascimento) VALUES (1, 'MASCULINO', date_sub(sysdate(), interval 27 year ));
insert into cliente_detalhe (cliente_id, sexo, data_nascimento) VALUES (2, 'MASCULINO', date_sub(sysdate(), interval 30 year ));

insert into pedido (id, cliente_id, data_criacao, total, status) values (1, 1, date_sub(sysdate(), interval 5 day ),2398.0, 'AGUARDANDO');
insert into pedido (id, cliente_id, data_criacao, total, status) values (2, 1, sysdate(),499.0, 'AGUARDANDO');
insert into pedido (id, cliente_id, data_criacao, total, status) values (3, 1, date_sub(sysdate(), interval 4 day), 3500.0, 'PAGO');
insert into pedido (id, cliente_id, data_criacao, total, status) values (4, 2, date_sub(sysdate(), interval 2 day), 499.0, 'PAGO');
insert into pedido (id, cliente_id, data_criacao, total, status) values (5, 1, date_sub(sysdate(), interval 2 day), 799.0, 'PAGO');


insert into item_pedido (pedido_id, produto_id, preco_produto, quantidade) values (1, 1, 499.0, 2);
insert into item_pedido (pedido_id, produto_id, preco_produto, quantidade) VALUES (1, 3, 1400, 1);
insert into item_pedido (pedido_id, produto_id, preco_produto, quantidade) values (2, 1, 499.0, 1);
insert into item_pedido (pedido_id, produto_id, preco_produto, quantidade) values (3, 4, 3500, 1);
insert into item_pedido (pedido_id, produto_id, preco_produto, quantidade) values (4, 1, 499, 1);
insert into item_pedido (pedido_id, produto_id, preco_produto, quantidade) values (5, 1, 799, 1);


insert into pagamento (pedido_id, status, tipo_pagamento, numero_cartao, codigo_barras) values (1, 'RECEBIDO', 'cartao', '0123', null);
insert into pagamento (pedido_id, status, tipo_pagamento, numero_cartao, codigo_barras) values (2, 'PROCESSANDO', 'cartao', '4567', null);
insert into pagamento (pedido_id, status, tipo_pagamento, numero_cartao, codigo_barras) values (3, 'RECEBIDO', 'boleto', null, '8910');
insert into pagamento (pedido_id, status, tipo_pagamento, numero_cartao, codigo_barras) values (4, 'PROCESSANDO', 'cartao', '1112', null);

insert into nota_fiscal (pedido_id, xml, data_emissao) VALUES (2, '<xml />', sysdate());

insert into categoria (nome) values ('Eletrodomésticos');
insert into categoria (nome) values ('Livros');
insert into categoria (nome) values ('Esportes');
insert into categoria (nome) values ('Futebol');
insert into categoria (nome) values ('Natação');
insert into categoria (nome) values ('Notebooks');
insert into categoria (nome) values ('Smartphones');
insert into categoria (id, nome) values (8, 'Câmeras');

insert into produto_categoria (produto_id, categoria_id) VALUES (1, 2);
insert into produto_categoria (produto_id, categoria_id) values (3, 8);
insert into produto_categoria (produto_id, categoria_id) values (4, 8);
