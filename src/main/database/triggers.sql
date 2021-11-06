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
