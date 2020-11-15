CREATE SEQUENCE comentario_seq_id AS INTEGER START 1 OWNED BY comentario.id;
ALTER TABLE comentario ALTER COLUMN id SET DEFAULT nextval('comentario_seq_id'); 