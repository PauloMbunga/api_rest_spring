CREATE TABLE comentario(
  id INT PRIMARY KEY,
  ordem_servico_id INT not null,
  descricao varchar(1000) not null,
  data_envio Timestamp with Time Zone not null
);


ALTER TABLE comentario add constraint fk_comentario_ordem_servico
foreign  key (ordem_servico_id) references ordem_servico (id);