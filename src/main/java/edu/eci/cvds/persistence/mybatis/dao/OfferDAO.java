package edu.eci.cvds.persistence.mybatis.dao;

import edu.eci.cvds.entities.User;
import edu.eci.cvds.persistence.PersistenceException;

/**
 * @author Laura Valentina García León
 * @author Laura Nathalia García
 * @author Juan Sebastián Cadavid
 * @author Juan David Murillo
 * @version 19/10/2021
 */
public interface OfferDAO {
    /**
     * Get the offer by its name
     * @param name The offer's name
     * @return
     * @throws PersistenceException
     */
    public User getOfferByName(String name) throws PersistenceException;

    /**
     * Get the offer by its id
     * @param id The user's email
     * @return
     * @throws PersistenceException
     */
    public User getOfferByID(String id) throws PersistenceException;

}


