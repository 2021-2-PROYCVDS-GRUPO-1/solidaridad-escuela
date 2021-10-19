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

CREATE TABLE Categorias(
Id SERIAL NOT NULL, 
Nombre VARCHAR(50) NOT NULL, 
Descripcion VARCHAR(150) NOT NULL, 
Fecha_Creacion DATE NOT NULL, 
Estado VARCHAR(40) NOT NULL, 
Fecha_Modificacion DATE NOT NULL, 
CONSTRAINT UC_Categoria UNIQUE (Nombre)
);

