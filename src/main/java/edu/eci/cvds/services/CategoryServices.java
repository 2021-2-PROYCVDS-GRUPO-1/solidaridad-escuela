package edu.eci.cvds.services;

import edu.eci.cvds.entities.Category;
import edu.eci.cvds.persistence.PersistenceException;

/**
 * @author Laura Valentina García León
 * @author Laura Nathalia García
 * @author Juan Sebastián Cadavid
 * @author Juan David Murillo
 * @version 28/10/2021
 */
public interface CategoryServices {
    /*
    SELECT
     */

    public Category getCategoryName(String name) throws ServicesException;
    public Category getCategoryId(int id) throws ServicesException;

    /*
    INSERT
     */
    public void addCategory(String name, String description, String state) throws ServicesException;

    /*
    UPDATE
     */

    public void upCategoryId(String id, String name, String description, String state) throws ServicesException;
    public void upCategoryName(String name, String description, String state) throws ServicesException;
}
