-- -----------------------------------------------------
-- Table `DB_USER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS DB_USER(
  userId        INTEGER        PRIMARY KEY,
  databaseId    SERIAL         NOT NULL,
  status        VARCHAR(40)    NOT NULL,
  firstName     VARCHAR(40)    NOT NULL,
  lastname      VARCHAR(40)    NOT NULL,
  email         VARCHAR(80)    NOT NULL,
  username      VARCHAR(40)    NOT NULL,
  password      VARCHAR(80)    NOT NULL,
  role          VARCHAR(40)    NOT NULL,
  UNIQUE(email, username)
);

