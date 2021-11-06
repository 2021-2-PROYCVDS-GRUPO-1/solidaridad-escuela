package edu.eci.cvds.services;

import edu.eci.cvds.entities.User;

/**
 * This is the class where all the DB calls and operations will be handled
 */
public interface Services {
    /**
     * This is the structure of the methods
     * @throws ServicesException
     */
    public void testMethod() throws ServicesException;

    public User getUserByEmail(String email ) throws ServicesException;
}
