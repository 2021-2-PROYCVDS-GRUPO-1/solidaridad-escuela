package edu.eci.cvds.persistence.mybatis;

//import com.google.inject.Inject;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatis.dao.UserDAO;
import edu.eci.cvds.persistence.mybatis.mappers.UserMapper;

import javax.inject.Inject;


/**
 * @author Laura Valentina García León
 * @author Laura Nathalia García
 * @author Juan Sebastián Cadavid
 * @author Juan David Murillo
 * @version 17/10/2021
 */
public class MyBATISUserDAO implements UserDAO {
    @Inject
    private UserMapper userMapper;

    @Override
    public User getUserByUsername(String username) throws PersistenceException {
        try {
            return userMapper.getUserByUsername(username);
        } catch (PersistenceException e){
            throw new PersistenceException("Error al consultar el usuario con username: " + username);
        }
    }

    @Override
    public User getUserByEmail(String email) throws PersistenceException {
        try {
            return userMapper.getUserByEmail(email);
        } catch (PersistenceException e){
            throw new PersistenceException("Error al consultar el usuario con correo: " + email);
        }
    }
}
