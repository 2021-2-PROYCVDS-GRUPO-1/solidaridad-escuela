package edu.eci.cvds.services;

import edu.eci.cvds.entities.Category;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.utils.DatabaseStatus;
import edu.eci.cvds.utils.Role;

import java.util.List;

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
    public User getUserByEmail(String email) throws ServicesException;
    public List<User> getAllUsers() throws ServicesException;

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
    public void updateUser(int userId,
                             String status,
                             String firstname,
                             String lastname,
                             String email,
                             String username,
                             String password,
                             String role,
                             int maxNeeds,
                             int databaseId) throws ServicesException;

    /*
    DELETE
     */
    public void deleteUser(int databaseId) throws ServicesException;

}
