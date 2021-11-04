package edu.eci.cvds.services.impl;

import edu.eci.cvds.entities.User;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatis.dao.UserDAO;
import edu.eci.cvds.services.ServicesException;
import edu.eci.cvds.services.Services;
import javax.inject.Inject;
import java.util.Optional;

/**
 * @author Laura Valentina García León
 * @author Laura Nathalia García
 * @author Juan Sebastián Cadavid
 * @author Juan David Murillo
 * @version 17/10/2021
 */
public class ServicesImpl implements Services{

    @Inject
    private UserDAO userDAO;

    @Override
    public void testMethod() throws ServicesException {

    }

    @Override
    public User getUserByEmail(String email) throws ServicesException {
        try{
            Optional<User> optionalUser = Optional.ofNullable(userDAO.getUserByEmail(email));
            optionalUser.orElseThrow(() -> new ServicesException(ServicesException.USER_NOT_FOUND));
            return optionalUser.get();
        }
        catch (PersistenceException persistenceException){
            throw new ServicesException(persistenceException.getMessage(), persistenceException);
        }
    }

    /*
    Insertar / INSERT / Agregar
     */

    /*
    Actualizar / UPDATE
     */
}
