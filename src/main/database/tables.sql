--- THIS IS JUST AN EXAMPLE
-- -----------------------------------------------------
-- Table `Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Usuario(
  idUsuario INTEGER PRIMARY KEY ,
  nombre VARCHAR(40)  NOT NULL,
  correo VARCHAR(50)  NOT NULL,
  contraseña VARCHAR(80)  NOT NULL,
  estado INTEGER  NOT NULL,
  rol VARCHAR(30) NOT NULL,
  UNIQUE(correo )
);

