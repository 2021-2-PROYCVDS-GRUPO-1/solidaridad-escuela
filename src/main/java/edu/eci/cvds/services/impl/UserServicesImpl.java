package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Category;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatis.dao.UserDAO;
import edu.eci.cvds.services.ServicesException;
import edu.eci.cvds.services.UserServices;

import java.util.List;

public class UserServicesImpl implements UserServices {
    @Inject
    private UserDAO userDAO;

    @Override
    public User getUserByEmail(String email) throws ServicesException {
        try{
            return userDAO.getUserByEmail(email);
        }
        catch (PersistenceException e){
            throw new ServicesException( e.getMessage(), e );
        }
    }

    @Override
    public List<User> getAllUsers() throws ServicesException {
        try {
            return userDAO.getAllUsers();
        } catch (PersistenceException e) {
            e.printStackTrace();
            throw new ServicesException( e.getMessage(), e );
        }
    }

    @Override
    public void registerUser(int userId, String status, String firstname, String lastname, String email, String username, String password, String role, int maxNeeds) throws ServicesException {
        try {
            userDAO.registerUser(userId, status, firstname, lastname, email, username, password, role, maxNeeds);
        } catch (PersistenceException e) {
            throw new ServicesException("Error al registrar el usuario con ID: " + userId + " y nombre: " + firstname);
        }

    }

    @Override
    public void updateUser(int userId, String status, String firstname, String lastname, String email, String username, String password, String role, int maxNeeds, int databaseId) throws ServicesException {
        try {
            userDAO.updateUser(userId, status, firstname, lastname, email, username, password, role, maxNeeds, databaseId);
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int databaseId) throws ServicesException {
        try {
            userDAO.deleteUser(databaseId);
        } catch (PersistenceException e){
            e.printStackTrace();
        }
    }
}
