package edu.eci.cvds.security;

import edu.eci.cvds.services.ServicesException;

/**
 * @author Laura Valentina García León
 * @author Laura Nathalia García
 * @author Juan Sebastián Cadavid
 * @author Juan David Murillo
 * @version 17/10/2021
 *
 * Interface that defines all the login methods for the users
 */
public interface Login {
    /**
     * Login method
     * @param email The user email
     * @param password  The user password
     * @param rememberMe The "remember me" checkbox value
     * @throws ServicesException
     */
    public void signIn(String email, String password, boolean rememberMe) throws ServicesException;

    /**
     * Method for logging out of the app
     * @throws ServicesException
     */
    public void logout() throws ServicesException;

    /**
     * Method that verifies if the user is logged in
     * @return True if the current user is logged in, false otherwise
     */
    public boolean isLoggedIn();
}
