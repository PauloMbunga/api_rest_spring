CREATE TABLE ordem_servico(
  id INT PRIMARY KEY,
  cliente_id int not null,
  descricao varchar(100) not null,
  preco decimal(10,2) not null,
  status varchar(20) not null,
  data_abertura datetime not null,
  data_finalizacao datetime
);


ALTER TABLE ordem_servico add constraint fk_ordem_servico_cliente
foreign  key (cliente_id) references cliente (id);