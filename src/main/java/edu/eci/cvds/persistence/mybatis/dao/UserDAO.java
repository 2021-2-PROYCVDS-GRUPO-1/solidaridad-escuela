package edu.eci.cvds.persistence.mybatis.dao;

import edu.eci.cvds.entities.User;
import edu.eci.cvds.persistence.PersistenceException;

/**
 * @author Laura Valentina García León
 * @author Laura Nathalia García
 * @author Juan Sebastián Cadavid
 * @author Juan David Murillo
 * @version 17/10/2021
 */
public interface UserDAO {
    /**
     * Get the user by its username
     * @param username The user's username
     * @return
     * @throws PersistenceException
     */
    public User getUserByUsername(String username) throws PersistenceException;

    /**
     * Get the user by its email
     * @param email The user's email
     * @return
     * @throws PersistenceException
     */
    public User getUserByEmail(String email) throws PersistenceException;

}
