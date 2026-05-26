CREATE SCHEMA IF NOT EXISTS banking;
SET search_path TO banking;

CREATE TABLE IF NOT EXISTS person (
  id              UUID PRIMARY KEY,
  name            VARCHAR(120) NOT NULL,
  gender          VARCHAR(20)  NOT NULL,
  identification  VARCHAR(30)  NOT NULL,
  address         VARCHAR(200) NOT NULL,
  phone           VARCHAR(20)  NOT NULL,

  created_at      TIMESTAMPTZ  NOT NULL DEFAULT now(),
  updated_at      TIMESTAMPTZ  NOT NULL DEFAULT now()
);

CREATE TABLE IF NOT EXISTS customer (
  id             UUID PRIMARY KEY,
  password_hash  VARCHAR(255) NOT NULL,
  status         BOOLEAN      NOT NULL DEFAULT TRUE,

  created_at     TIMESTAMPTZ  NOT NULL DEFAULT now(),
  updated_at     TIMESTAMPTZ  NOT NULL DEFAULT now(),

  CONSTRAINT fk_customer_person
    FOREIGN KEY (id) REFERENCES person(id)
    ON DELETE CASCADE
);

ALTER TABLE person
  DROP CONSTRAINT IF EXISTS chk_person_gender;

ALTER TABLE person
  ADD CONSTRAINT chk_person_gender
  CHECK (gender IN ('MALE', 'FEMALE', 'OTHER'));

-- Jose Lema
INSERT INTO person (id, name, gender, identification, address, phone)
VALUES ('11111111-1111-1111-1111-111111111111', 'Jose Lema', 'MALE', '0102030405', 'Otavalo sn y principal', '098254785');

INSERT INTO customer (id, password_hash, status)
VALUES ('11111111-1111-1111-1111-111111111111', '$2a$10$replace_with_bcrypt_hash', TRUE);

-- Marianela Montalvo
INSERT INTO person (id, name, gender, identification, address, phone)
VALUES ('22222222-2222-2222-2222-222222222222', 'Marianela Montalvo', 'FEMALE', '0102030406', 'Amazonas y NNUU', '097548965');

INSERT INTO customer (id, password_hash, status)
VALUES ('22222222-2222-2222-2222-222222222222', '$2a$10$replace_with_bcrypt_hash', TRUE);

-- Juan Osorio
INSERT INTO person (id, name, gender, identification, address, phone)
VALUES ('33333333-3333-3333-3333-333333333333', 'Juan Osorio', 'MALE', '0102030407', '13 junio y Equinoccial', '098874587');

INSERT INTO customer (id, password_hash, status)
VALUES ('33333333-3333-3333-3333-333333333333', '$2a$10$REPLACE_WITH_BCRYPT_HASH', TRUE);
