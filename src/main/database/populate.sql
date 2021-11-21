-- -----------------------------------------------------
-- Table `DB_USER`
-- -----------------------------------------------------
 INSERT INTO DB_USER (userid, status, firstname, lastname, email, username, password, role, maxneeds) VALUES (1026306639, 'ENABLED', 'Juan David', 'Murillo', 'juan.murillo-g@mail.escuelaing.edu.co', 'juancho20sp', 'admin', 'ADMIN', 5);
 INSERT INTO DB_USER (userid, status, firstname, lastname, email, username, password, role, maxneeds) VALUES (1000238552, 'ENABLED', 'Juan', 'Cadavid', 'juan.cadavid-p@mail.escuelaing.edu.co', 'kukis', '123456789', 'ADMIN', 5);
 INSERT INTO db_user (userid, status, firstname, lastname, email, username, password, role, maxneeds) VALUES (7,'ENABLED','Laura','García','laura.garcia-a@mail.escuelaing.edu.co','lngar','fvdbnt','ADMIN',5);

-- -----------------------------------------------------
-- Table `DB_CATEGORY`
-- -----------------------------------------------------
 INSERT INTO DB_Category (name, description, state) VALUES ('Kukis', 'Test trigger  create and modification', 'Completo');

 -- -----------------------------------------------------
 -- Table `DB_OFFERs`
 -- -----------------------------------------------------
 INSERT INTO DB_OFFERS (offerCategory, name, description, status, userid, maxneeds) VALUES (7, 'Prueba2', 'Esto es una prueba', 'ACTIVE', 1001184238, 7);
 INSERT INTO DB_OFFERS (offerCategory, name, description, status, userid) VALUES (7, 'Prueba2', 'Esto es una prueba', 'ACTIVE', 1001184238)

-- -----------------------------------------------------
-- Table `DB_ANSWER`
-- -----------------------------------------------------
 INSERT INTO DB_Answer(Name, Comments, IdOffer, IdNeeds) VALUES('Juan', 'Insert desde la base de datos', 3, NULL);