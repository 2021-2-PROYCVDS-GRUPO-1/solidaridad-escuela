package edu.eci.cvds.persistence.mybatis.dao;

import edu.eci.cvds.entities.User;
import edu.eci.cvds.persistence.PersistenceException;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    public List<User> getAllUsers() throws PersistenceException;

    /**
     * Register user
     * @param userId
     * @param status
     * @param firstName
     * @param lastname
     * @param email
     * @param username
     * @param password
     * @param role
     * @param maxNeeds
     */
    public void registerUser(
            @Param("userId") int userId,
            @Param("status") String status,
            @Param("firstName") String firstName,
            @Param("lastname") String lastname,
            @Param("email") String email,
            @Param("username") String username,
            @Param("password") String password,
            @Param("role") String role,
            @Param("maxNeeds") int maxNeeds
    ) throws PersistenceException;

    public void updateUser(
            @Param("userId") int userId,
            @Param("status") String status,
            @Param("firstName") String firstName,
            @Param("lastname") String lastname,
            @Param("email") String email,
            @Param("username") String username,
            @Param("password") String password,
            @Param("role") String role,
            @Param("maxNeeds") int maxNeeds,
            @Param("databaseId") int databaseId
    ) throws PersistenceException;

    public void deleteUser(@Param("databaseId") int databaseId) throws PersistenceException;
}
