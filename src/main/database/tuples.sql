-- -----------------------------------------------------
-- Table `DB_USER`
-- -----------------------------------------------------
ALTER TABLE DB_USER
ADD CONSTRAINT CK_USER_ROLE
CHECK(
	role IN ('ADMIN', 'STUDENT', 'TEACHER', 'GRADUATED', 'ADMINISTRATIVE')
);

ALTER TABLE DB_USER
ADD CONSTRAINT CK_USER_STATUS
CHECK(
	status IN ('ENABLED', 'DISABLED')
);

-- -----------------------------------------------------
-- Table `DB_OFFERS`
-- -----------------------------------------------------
ALTER TABLE DB_OFFERS
ADD CONSTRAINT CK_OFFER_STATUS
CHECK (
    status IN ('ACTIVE', 'IN PROCESS', 'SOLVED', 'CLOSED')
);