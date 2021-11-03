package edu.eci.cvds.persistence.mybatis.dao;

import edu.eci.cvds.entities.Category;
import edu.eci.cvds.persistence.PersistenceException;

/**
 * @author Laura Valentina García León
 * @author Laura Nathalia García
 * @author Juan Sebastián Cadavid
 * @author Juan David Murillo
 * @version 19/10/2021
 */
public interface CategoryDAO {
    /**
     * Get the Category by its name
     * @param name The name of category
     * @return
     * @throws PersistenceException
     */
    public Category getCategoryName(String name) throws PersistenceException;

    /**
     * Get the Category by its id
     * @param id The id of category
     * @return
     * @throws PersistenceException
     */
    public Category getCategoryId(String id) throws PersistenceException;
}
