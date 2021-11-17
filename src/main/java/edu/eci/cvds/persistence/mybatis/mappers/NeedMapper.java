package edu.eci.cvds.persistence.mybatis.mappers;

import edu.eci.cvds.entities.Need;
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

public interface NeedMapper {

    public void registerNeed(@Param("name") String name,
                             @Param("description") String description,
                             @Param("status") String status,
                             @Param("categoryId") int categoryId,
                             @Param("urgency") String urgency,
                             @Param("createdByUser") int createdByUser) throws PersistenceException;

    public User getNeedByName(@Param("name") String name) throws PersistenceException;

    public User getNeedByID(@Param("id") String name) throws PersistenceException;
}
