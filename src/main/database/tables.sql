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

-- -----------------------------------------------------
-- Table `DB_Category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS DB_Category(
Id SERIAL NOT NULL, 
Name VARCHAR(50) NOT NULL, 
Description VARCHAR(150) NOT NULL, 
Date_Create DATE NOT NULL, 
State VARCHAR(40) NOT NULL, 
Date_Modification  DATE NOT NULL, 
CONSTRAINT UC_Category UNIQUE (Name)
);
