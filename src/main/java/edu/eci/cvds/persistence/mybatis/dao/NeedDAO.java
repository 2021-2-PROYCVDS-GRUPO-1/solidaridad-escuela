package edu.eci.cvds.persistence.mybatis.dao;

import edu.eci.cvds.entities.Need;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.persistence.PersistenceException;

/**
 * @author Laura Valentina García León
 * @author Laura Nathalia García
 * @author Juan Sebastián Cadavid
 * @author Juan David Murillo
 * @version 19/10/2021
 */
public interface NeedDAO {

    public void save(Need necesidad) throws PersistenceException;

    /**
     * Get the Need by its name
     * @param name The offer's name
     * @return
     * @throws PersistenceException
     */
    public User getNeedByName(String name) throws PersistenceException;

    /**
     * Get the Need by its id
     * @param id
     * @return
     * @throws PersistenceException
     */
    public User getNeedByID(String id) throws PersistenceException;


}
