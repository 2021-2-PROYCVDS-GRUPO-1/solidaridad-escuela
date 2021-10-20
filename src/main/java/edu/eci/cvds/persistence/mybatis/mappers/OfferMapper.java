package edu.eci.cvds.persistence.mybatis.mappers;


import edu.eci.cvds.entities.User;
import edu.eci.cvds.persistence.PersistenceException;
import org.apache.ibatis.annotations.Param;

/**
 * @author Laura Valentina García León
 * @author Laura Nathalia García
 * @author Juan Sebastián Cadavid
 * @author Juan David Murillo
 * @version 19/10/2021
 */

public interface OfferMapper {
    public User getOfferByName(@Param("name") String name) throws PersistenceException;

    public User getOfferByID(@Param("id") String id) throws PersistenceException;
}
