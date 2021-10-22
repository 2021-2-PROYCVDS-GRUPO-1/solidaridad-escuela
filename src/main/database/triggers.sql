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
----------------------------------------------------------

-- Date Modification
CREATE OR REPLACE FUNCTION dateModificationOffer()
    RETURNS TRIGGER
AS
'
BEGIN
    NEW.dateModification := CURRENT_DATE;
    RETURN NEW;
END;
'
LANGUAGE plpgsql;

CREATE TRIGGER AD_dateModificationOffer
  BEFORE INSERT ON public.DB_OFFERS
  FOR EACH ROW
EXECUTE PROCEDURE dateModificationOffer();

-- Date Creation
CREATE OR REPLACE FUNCTION dateCreationOffer()
    RETURNS TRIGGER
AS
'
BEGIN
    NEW.dateCreation := CURRENT_DATE;
    RETURN NEW;
END;
'
LANGUAGE plpgsql;

CREATE TRIGGER AD_dateCreationOffer
  BEFORE INSERT ON public.DB_OFFERS
  FOR EACH ROW
EXECUTE PROCEDURE dateCreationOffer();

-- Update date modification

CREATE TRIGGER UP_dateModificationOffer
  BEFORE UPDATE ON public.DB_OFFERS
  FOR EACH ROW
EXECUTE PROCEDURE dateModificationOffer();




-------------------------------------------------------


