DROP TABLE entidade_entidade;

CREATE TABLE entidade_entidade (
    ents_codigo bigint NOT NULL,
    ent_codconstrutora bigint NOT NULL,
    ent_codvendedor bigint NOT NULL,
    versionnum integer NOT NULL
);
ALTER TABLE entidade_entidade
  OWNER TO caixaki;

  
  
DROP TABLE entidade_entidade_aud;

CREATE TABLE entidade_entidade_aud (
    ents_codigo bigint NOT NULL,
    rev integer NOT NULL,
    revtype smallint NOT NULL,
    ent_codconstrutora bigint,
    ent_codvendedor bigint
);

ALTER TABLE entidade_entidade_aud
  OWNER TO caixaki;
  
