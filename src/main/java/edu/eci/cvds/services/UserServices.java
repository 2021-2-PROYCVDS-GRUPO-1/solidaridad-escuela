package edu.eci.cvds.services;

import edu.eci.cvds.entities.Category;
import edu.eci.cvds.utils.DatabaseStatus;
import edu.eci.cvds.utils.Role;

/**
 * @author Laura Valentina García León
 * @author Laura Nathalia García
 * @author Juan Sebastián Cadavid
 * @author Juan David Murillo
 * @version 28/10/2021
 */
public interface UserServices {
    /*
    SELECT
     */

    public Category getCategoryName(String name) throws ServicesException;
    public Category getCategoryId(int id) throws ServicesException;

    /*
    INSERT
     */
    public void registerUser(int userId,
            String status,
            String firstname,
            String lastname,
            String email,
            String username,
            String password,
            String role,
            int maxNeeds) throws ServicesException;

    /*
    UPDATE
     */

    public void upCategoryId(String id, String name, String description, String state) throws ServicesException;
    public void upCategoryName(String name, String description, String state) throws ServicesException;
}
