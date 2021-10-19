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
-- Table Offer


---PRUEBA--------
CREATE OR REPLACE FUNCTION fechaOffer()
    RETURNS TRIGGER
AS
$$
BEGIN
    NEW.Date_Modification := CURRENT_DATE;
    RETURN NEW;
END;
LANGUAGE plpgsql;

CREATE TRIGGER AD_dateModification_Offer
  BEFORE INSERT ON public.Offer
  FOR EACH ROW
EXECUTE PROCEDURE fechaOffer();
-------------------------------------------------------


