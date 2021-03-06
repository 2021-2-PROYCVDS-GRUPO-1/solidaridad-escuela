package edu.eci.cvds.persistence.mybatis.mappers;

import edu.eci.cvds.entities.Need;
import edu.eci.cvds.persistence.PersistenceException;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Laura Valentina García León
 * @author Laura Nathalia García
 * @author Juan Sebastián Cadavid
 * @author Juan David Murillo
 * @version 19/10/2021
 */

public interface NeedMapper {

    // CREATE
    public void registerNeed(@Param("categoryId") int categoryId,
                             @Param("name") String name,
                             @Param("description") String description,
                             @Param("urgency") String urgency,
                             @Param("status") String status,
                             @Param("createdByUser") int createdByUser) throws PersistenceException;

    // READ
    public List<Need> getAllNeeds() throws PersistenceException;

    public List<Need> getByStatus(@Param("status") String status) throws  PersistenceException;

    // UPDATE
    public void updateStatus(@Param("id") int id, @Param("status") String status);

    // DELETE
    public void deleteNeed(@Param("id") int needId) throws PersistenceException;
}
