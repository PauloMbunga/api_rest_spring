CREATE SEQUENCE ordem_servico_seq_id AS INTEGER START 1 OWNED BY ordem_servico.id;
ALTER TABLE ordem_servico ALTER COLUMN id SET DEFAULT nextval('ordem_servico_seq_id'); 