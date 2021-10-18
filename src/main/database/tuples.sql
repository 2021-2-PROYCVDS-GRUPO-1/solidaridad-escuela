--- THIS IS JUST AN EXAMPLE ---
-- -----------------------------------------------------
-- Table `Battalion`
-- -----------------------------------------------------
ALTER TABLE Battalion
	 ADD CONSTRAINT CK_BATTALION_MILFORCE
	 CHECK (militaryForce IN ('Fuerza Aerea', 'Armada', 'Ejercito'));