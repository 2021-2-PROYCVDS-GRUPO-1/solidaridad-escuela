DROP TRIGGER  IF EXISTS AD_dateModificationOffer ON DB_OFFERS CASCADE;
DROP TRIGGER IF EXISTS AD_dateCreationOffer ON DB_OFFERS CASCADE;

DROP FUNCTION dateModificationOffer CASCADE;
DROP FUNCTION dateCreationOffer CASCADE;