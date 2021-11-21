package edu.eci.cvds.persistence.mybatis.mappers;

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
public interface UserMapper {
    public User getUserByUsername(@Param("username") String username) throws PersistenceException;

    public User getUserByEmail(@Param("email") String email) throws PersistenceException;

    public List<User> getAllUsers() throws PersistenceException;

    public void registerUser(@Param("userId") int userId,
                             @Param("status") String status,
                             @Param("firstName") String firstName,
                             @Param("lastname") String lastname,
                             @Param("email") String email,
                             @Param("username") String username,
                             @Param("password") String password,
                             @Param("role") String role,
                             @Param("maxNeeds") int maxNeeds)
            throws PersistenceException;

    public void updateUser(@Param("userId") int userId,
                             @Param("status") String status,
                             @Param("firstName") String firstName,
                             @Param("lastname") String lastname,
                             @Param("email") String email,
                             @Param("username") String username,
                             @Param("password") String password,
                             @Param("role") String role,
                             @Param("maxNeeds") int maxNeeds,
                             @Param("databaseId") int databaseId)
            throws PersistenceException;

    public void deleteUser(@Param("databaseId") int databaseId) throws PersistenceException;
}
