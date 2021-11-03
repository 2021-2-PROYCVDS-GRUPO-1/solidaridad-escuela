package edu.eci.cvds.persistence.mybatis.mappers;

import edu.eci.cvds.entities.User;
import edu.eci.cvds.persistence.PersistenceException;
import org.apache.ibatis.annotations.Param;

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
}
