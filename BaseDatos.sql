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

CREATE TABLE IF NOT EXISTS account (
  id              UUID PRIMARY KEY,
  customer_id     UUID         NOT NULL,
  account_number  VARCHAR(20)  NOT NULL,
  type            VARCHAR(20)  NOT NULL,
  initial_balance NUMERIC(19,2) NOT NULL,
  current_balance NUMERIC(19,2) NOT NULL,
  status          BOOLEAN      NOT NULL DEFAULT TRUE,

  created_at      TIMESTAMPTZ  NOT NULL DEFAULT now(),
  updated_at      TIMESTAMPTZ  NOT NULL DEFAULT now(),

  CONSTRAINT uk_account_account_number UNIQUE (account_number),
  CONSTRAINT fk_account_customer FOREIGN KEY (customer_id) REFERENCES customer(id) ON DELETE RESTRICT,
  CONSTRAINT chk_account_type CHECK (type IN ('SAVINGS', 'CHECKING')),
  CONSTRAINT chk_account_initial_balance CHECK (initial_balance >= 0),
  CONSTRAINT chk_account_current_balance CHECK (current_balance >= 0)
);

CREATE TABLE IF NOT EXISTS movement (
  id              UUID PRIMARY KEY,
  account_id      UUID          NOT NULL,
  date            DATE          NOT NULL,
  type            VARCHAR(20)   NOT NULL,
  value           NUMERIC(19,2) NOT NULL,
  balance_after   NUMERIC(19,2) NOT NULL,

  created_at      TIMESTAMPTZ   NOT NULL DEFAULT now(),
  updated_at      TIMESTAMPTZ   NOT NULL DEFAULT now(),

  CONSTRAINT fk_movement_account FOREIGN KEY (account_id) REFERENCES account(id) ON DELETE CASCADE,
  CONSTRAINT chk_movement_type CHECK (type IN ('DEBIT', 'CREDIT')),
  CONSTRAINT chk_movement_value CHECK (value > 0),
  CONSTRAINT chk_movement_balance_after CHECK (balance_after >= 0)
);

CREATE INDEX IF NOT EXISTS idx_movement_account_date ON movement(account_id, date);


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

-- Jose Lema - 478758 SAVINGS 2000
INSERT INTO account (id, customer_id, account_number, type, initial_balance, current_balance, status)
VALUES ('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaa1', '11111111-1111-1111-1111-111111111111', '478758', 'SAVINGS', 2000.00, 2000.00, TRUE)
ON CONFLICT (account_number) DO NOTHING;

-- Marianela Montalvo - 225487 CHECKING 100
INSERT INTO account (id, customer_id, account_number, type, initial_balance, current_balance, status)
VALUES ('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaa2', '22222222-2222-2222-2222-222222222222', '225487', 'CHECKING', 100.00, 100.00, TRUE)
ON CONFLICT (account_number) DO NOTHING;

-- Juan Osorio - 495878 SAVINGS 0
INSERT INTO account (id, customer_id, account_number, type, initial_balance, current_balance, status)
VALUES ('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaa3', '33333333-3333-3333-3333-333333333333', '495878', 'SAVINGS', 0.00, 0.00, TRUE)
ON CONFLICT (account_number) DO NOTHING;

-- Marianela Montalvo - 496825 SAVINGS 540
INSERT INTO account (id, customer_id, account_number, type, initial_balance, current_balance, status)
VALUES ('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaa4', '22222222-2222-2222-2222-222222222222', '496825', 'SAVINGS', 540.00, 540.00, TRUE)
ON CONFLICT (account_number) DO NOTHING;

-- 1) Jose Lema - Retiro (DEBIT) 575 from account 478758: 2000 -> 1425
INSERT INTO movement (id, account_id, date, type, value, balance_after)
VALUES ('bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbb1', 'aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaa1', '2022-02-10', 'DEBIT', 575.00, 1425.00)
ON CONFLICT (id) DO NOTHING;

UPDATE account
SET current_balance = 1425.00, updated_at = now()
WHERE id = 'aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaa1';

-- 2) Marianela - Depósito (CREDIT) 600 to account 225487: 100 -> 700
INSERT INTO movement (id, account_id, date, type, value, balance_after)
VALUES ('bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbb2', 'aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaa2', '2022-02-10', 'CREDIT', 600.00, 700.00)
ON CONFLICT (id) DO NOTHING;

UPDATE account
SET current_balance = 700.00, updated_at = now()
WHERE id = 'aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaa2';

-- 3) Juan - Depósito (CREDIT) 150 to account 495878: 0 -> 150
INSERT INTO movement (id, account_id, date, type, value, balance_after)
VALUES ('bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbb3', 'aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaa3', '2022-02-09', 'CREDIT', 150.00, 150.00)
ON CONFLICT (id) DO NOTHING;

UPDATE account
SET current_balance = 150.00, updated_at = now()
WHERE id = 'aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaa3';

-- 4) Marianela - Retiro (DEBIT) 540 from account 496825: 540 -> 0
INSERT INTO movement (id, account_id, date, type, value, balance_after)
VALUES ('bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbb4', 'aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaa4', '2022-02-08', 'DEBIT', 540.00, 0.00)
ON CONFLICT (id) DO NOTHING;

UPDATE account
SET current_balance = 0.00, updated_at = now()
WHERE id = 'aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaa4';