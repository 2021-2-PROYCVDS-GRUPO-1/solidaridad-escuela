-- -----------------------------------------------------
-- Table `DB_CATEGORY`
-- -----------------------------------------------------
DROP TRIGGER AD_DateCreate_Category ON DB_Category;
DROP FUNCTION AD_date_Create;

DROP TRIGGER ADUP_DateModification_Category ON DB_Category;
DROP FUNCTION ADUP_date_Modification;

-- -----------------------------------------------------
-- Table `DB_OFEFRS`
-- -----------------------------------------------------
DROP TRIGGER  IF EXISTS AD_dateModificationOffer ON DB_OFFERS CASCADE;
DROP FUNCTION dateModificationOffer CASCADE;

DROP TRIGGER  IF EXISTS AD_dateCreationOffer ON DB_OFFERS CASCADE;
DROP FUNCTION dateCreationOffer CASCADE;

DROP TRIGGER IF EXISTS UP_dateModificationOffer ON DB_OFFERS CASCADE;

-- -----------------------------------------------------
-- Table `DB_NEEDS`
-- -----------------------------------------------------
DROP TRIGGER  IF EXISTS AD_dateModificationNeed ON DB_Needs CASCADE;
DROP TRIGGER IF EXISTS AD_dateCreationNeeds ON DB_Needs CASCADE;
DROP TRIGGER IF EXISTS VAL_NEED ON DB_Needs CASCADE;

DROP FUNCTION dateModificationNeed CASCADE;
DROP FUNCTION dateCreationNeed CASCADE;
DROP FUNCTION validate_registration_need CASCADE;

-- -----------------------------------------------------
-- Table `DB_ANSWER`
-- -----------------------------------------------------
DROP TRIGGER AD_DateCreate_Answer ON DB_Answer;
DROP FUNCTION AD_date_Create;

