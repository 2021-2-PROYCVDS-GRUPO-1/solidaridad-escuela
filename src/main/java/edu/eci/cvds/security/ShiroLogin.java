package edu.eci.cvds.security;

import edu.eci.cvds.services.ServicesException;

/**
 * @author Laura Valentina García León
 * @author Laura Nathalia García
 * @author Juan Sebastián Cadavid
 * @author Juan David Murillo
 * @version 17/10/2021
 */
public class ShiroLogin implements Login {

    @Override
    public void signIn(String email, String password, boolean rememberMe) throws ServicesException {

    }

    @Override
    public void signUp() throws ServicesException {

    }

    @Override
    public void logout() throws ServicesException {

    }

    @Override
    public boolean isLoggedIn() {
        return false;
    }
}
