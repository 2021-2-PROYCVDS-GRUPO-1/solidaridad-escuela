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

----------------------------------------------------------
-- Table DB_OFFERS


---PRUEBA--------
CREATE OR REPLACE FUNCTION dateModificationOffer()
    RETURNS TRIGGER
AS
$$
BEGIN
    NEW.dateModification := CURRENT_DATE;
    RETURN NEW;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER AD_dateModificationOffer
  BEFORE INSERT ON public.DB_OFFERS
  FOR EACH ROW
EXECUTE PROCEDURE dateModificationOffer();
-------------------------------------------------------


