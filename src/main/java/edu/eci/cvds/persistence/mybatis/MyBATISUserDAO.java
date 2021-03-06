package edu.eci.cvds.persistence.mybatis;

import edu.eci.cvds.entities.User;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatis.dao.UserDAO;
import edu.eci.cvds.persistence.mybatis.mappers.UserMapper;

import javax.inject.Inject;
import java.util.List;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 11/5/2020
 */
public class MyBATISUserDAO implements UserDAO {
    @Inject
    private UserMapper userMapper;

    @Override
    public User getUserByUsername(String username) throws PersistenceException {
        try{
            return userMapper.getUserByUsername( username );
        }
        catch (Exception exception){
            throw new PersistenceException("Error al consultar al usuario con username "+ username);
        }

    }

    @Override
    public User getUserByEmail(String email) throws PersistenceException {
        try{
            return userMapper.getUserByEmail( email );
        }
        catch (Exception exception){
            throw new PersistenceException("Error al consultar al usuario con email "+ email);
        }
    }

    @Override
    public List<User> getAllUsers() throws PersistenceException {
        try {
            return userMapper.getAllUsers();
        } catch (Exception e){
            throw new PersistenceException("Error al consultar la lista de usuarios");
        }
    }

    @Override
    public void registerUser(int userId, String status, String firstName, String lastname, String email, String username, String password, String role, int maxNeeds) throws PersistenceException {
        try {
            userMapper.registerUser(userId, status, firstName, lastname, email, username, password, role, maxNeeds);
        } catch (PersistenceException e){
            throw  new PersistenceException("Error al registrar el usuario con ID: " + userId);
        }
    }

    @Override
    public void updateUser(int userId, String status, String firstName, String lastname, String email, String username, String password, String role, int maxNeeds, int databaseId) throws PersistenceException {
        try {
            userMapper.updateUser(userId, status,  firstName, lastname, email, username, password, role, maxNeeds, databaseId);
        } catch (PersistenceException e){
            throw new PersistenceException("Error al actualizar el usuario con ID: " + userId);
        }
    }

    @Override
    public void deleteUser(int databaseId) throws PersistenceException {
        try {
            userMapper.deleteUser(databaseId);
        } catch (PersistenceException e){
            throw new PersistenceException("Error al eliminar el usuario don DB ID: " + databaseId);
        }
    }
}
