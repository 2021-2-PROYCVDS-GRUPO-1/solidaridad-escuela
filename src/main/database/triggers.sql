--- THIS IS JUST AN EXAMPLE
-- -----------------------------------------------------
-- Table `Usuario`
-- -----------------------------------------------------
CREATE OR REPLACE FUNCTION fechaEquipo()
	RETURNS TRIGGER
AS
$$
BEGIN
	NEW.fechaRegistro := CURRENT_DATE;
	RETURN NEW;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER AD_fechaRegistro_Equipo
  BEFORE INSERT ON public.Equipo
  FOR EACH ROW
EXECUTE PROCEDURE fechaEquipo();

-- Table `Category`
-- -----------------------------------------------------
CREATE FUNCTION AD_date_Create() RETURNS TRIGGER AS ' BEGIN NEW.Date_Create := CURRENT_DATE; RETURN NEW; END; ' LANGUAGE plpgsql;
CREATE TRIGGER AD_DateCreate_Category BEFORE INSERT ON DB_Category FOR EACH ROW EXECUTE PROCEDURE AD_date_Create();

CREATE FUNCTION ADUP_date_Modification() RETURNS TRIGGER AS ' BEGIN NEW.Date_Modification := CURRENT_DATE; RETURN NEW; END; ' LANGUAGE plpgsql;
CREATE TRIGGER ADUP_DateModification_Category BEFORE INSERT OR UPDATE ON DB_Category FOR EACH ROW EXECUTE PROCEDURE ADUP_date_Modification();