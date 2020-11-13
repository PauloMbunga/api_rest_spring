CREATE SEQUENCE cliente_seq_id AS INTEGER START 1 OWNED BY cliente.id;
ALTER TABLE cliente ALTER COLUMN id SET DEFAULT nextval('cliente_seq_id'); 