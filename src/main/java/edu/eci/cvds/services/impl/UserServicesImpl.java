package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Category;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatis.dao.UserDAO;
import edu.eci.cvds.services.ServicesException;
import edu.eci.cvds.services.UserServices;

public class UserServicesImpl implements UserServices {
    @Inject
    private UserDAO userDAO;

    @Override
    public Category getCategoryName(String name) throws ServicesException {
        return null;
    }

    @Override
    public Category getCategoryId(int id) throws ServicesException {
        return null;
    }

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
    public void registerUser(int userId, String status, String firstname, String lastname, String email, String username, String password, String role, int maxNeeds) throws ServicesException {
        try {
            userDAO.registerUser(userId, status, firstname, lastname, email, username, password, role, maxNeeds);
        } catch (PersistenceException e) {
            throw new ServicesException("Error al registrar el usuario con ID: " + userId + " y nombre: " + firstname);
        }

    }

    @Override
    public void upCategoryId(String id, String name, String description, String state) throws ServicesException {

    }

    @Override
    public void upCategoryName(String name, String description, String state) throws ServicesException {

    }

}
