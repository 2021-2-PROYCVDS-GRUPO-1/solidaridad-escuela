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

-- -----------------------------------------------------
-- Table `Need`
-- -----------------------------------------------------

--Register need
CREATE OR REPLACE FUNCTION validate_registration_need()
    RETURNS TRIGGER
AS
'
	DECLARE
		max_needs	INTEGER;
		count_needs	INTEGER;
	BEGIN
		SELECT  maxNeeds INTO max_needs FROM DB_USER;
		SELECT COUNT(*) INTO count_needs FROM DB_NEEDS WHERE idUser=idUser;
		if (max_needs > count_needs) THEN
			INSERT INTO DB_Needs (category,name,description,urgency,creationDate,status,modificationDate,idUser)
        		VALUES (NEW.category,NEW.name,NEW.description,NEW.urgency,CURRENT_DATE,"Active",CURRENT_DATE,NEW.idUser);
        		RETURN NEW;
		else
			RETURN ("el numero de necesidades registradas alcanzo su maximo");
		END if;
	END;
'

LANGUAGE plpgsql;

CREATE TRIGGER VAL_NEED
  BEFORE INSERT ON public.DB_NEEDS
  FOR EACH ROW
EXECUTE PROCEDURE validate_registration_need();


-- Date Modification
CREATE OR REPLACE FUNCTION dateModificationNeed()
    RETURNS TRIGGER
AS
'
BEGIN
    NEW.modificationDate := CURRENT_DATE;
    RETURN NEW;
END;
'
LANGUAGE plpgsql;

CREATE TRIGGER AD_dateModificationNeed
  BEFORE INSERT ON public.DB_NEEDS
  FOR EACH ROW
EXECUTE PROCEDURE dateModificationNeed();

-- Date Creation
CREATE OR REPLACE FUNCTION dateCreationNeed()
    RETURNS TRIGGER
AS
'
BEGIN
    NEW.creationDate := CURRENT_DATE;
    RETURN NEW;
END;
'
LANGUAGE plpgsql;

CREATE TRIGGER AD_dateCreationNeed
  BEFORE INSERT ON public.DB_NEEDS
  FOR EACH ROW
EXECUTE PROCEDURE dateCreationNeed();

-- Update date modification

CREATE TRIGGER UP_dateModificationNeed
  BEFORE UPDATE ON public.DB_NEEDS
  FOR EACH ROW
EXECUTE PROCEDURE dateModificationNeed();

-- -----------------------------------------------------
-- Table `Answer`
-- -----------------------------------------------------
CREATE FUNCTION AD_date_Create() RETURNS TRIGGER AS ' BEGIN NEW.Date_Create := CURRENT_DATE; RETURN NEW; END; ' LANGUAGE plpgsql;
CREATE TRIGGER AD_DateCreate_Answer BEFORE INSERT ON DB_Answer FOR EACH ROW EXECUTE PROCEDURE AD_date_Create();



