CREATE TABLE ordem_servico(
  id INT PRIMARY KEY,
  cliente_id INT not null,
  descricao varchar(100) not null,
  preco decimal(10,2) not null,
  status varchar(20) not null,
  data_abertura Timestamp with Time Zone not null,
  data_finalizacao Timestamp with Time Zone
);


ALTER TABLE ordem_servico add constraint fk_ordem_servico_cliente
foreign  key (cliente_id) references cliente (id);