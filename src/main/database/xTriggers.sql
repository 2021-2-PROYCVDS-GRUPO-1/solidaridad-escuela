DROP TRIGGER  IF EXISTS AD_dateModificationNeed ON DB_Needs CASCADE;
DROP TRIGGER IF EXISTS AD_dateCreationNeeds ON DB_Needs CASCADE;
DROP TRIGGER IF EXISTS VAL_NEED ON DB_Needs CASCADE;
DROP FUNCTION dateModificationNeed CASCADE;
DROP FUNCTION dateCreationNeed CASCADE;
DROP FUNCTION validate_registration_need CASCADE;