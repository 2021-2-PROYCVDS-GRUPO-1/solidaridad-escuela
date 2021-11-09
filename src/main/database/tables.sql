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
  maxneeds      INTEGER        NOT NULL
  UNIQUE(email, username)
);

-- -----------------------------------------------------
-- Table `DB_Category`
-- -----------------------------------------------------
CREATE TABLE DB_Category(
Id SERIAL PRIMARY KEY,
Name VARCHAR(50) NOT NULL,
Description VARCHAR(150) NOT NULL,
Date_Create DATE NOT NULL,
State VARCHAR(40) NOT NULL,
Date_Modification  DATE,
CONSTRAINT UC_Category UNIQUE (Name)
);

-- -----------------------------------------------------
-- Table `DB_Offer`
-- -----------------------------------------------------

CREATE TABLE DB_OFFERS (
 offerId            SERIAL          PRIMARY KEY,
 offerCategory      VARCHAR(50)     NOT NULL,
 name               VARCHAR(50)     NOT NULL,
 description        VARCHAR(100)    NOT NULL,
 status             VARCHAR(50)     NOT NULL,
 dateCreation       DATE            NOT NULL,
 dateModification   DATE            NOT NULL,
 userId             INTEGER         NOT NULL
);

