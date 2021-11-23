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

    public void registerNeed(@Param("categoryId") int categoryId,
                             @Param("name") String name,
                             @Param("description") String description,
                             @Param("urgency") String urgency,
                             @Param("status") String status,
                             @Param("createdByUser") int createdByUser) throws PersistenceException;

    public void updateStatus(@Param("id") int id, @Param("status") String status);

    public Need getNeedByName(@Param("name") String name) throws PersistenceException;

    public Need getNeedByID(@Param("id") int id) throws PersistenceException;

    public List<Need> getAllNeeds() throws PersistenceException;

    public void deleteNeed(@Param("id") int needId) throws PersistenceException;
}
