package edu.eci.cvds.persistence.mybatis.dao;

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
public interface NeedDAO {

    public void addNecessity(@Param("categoryId") int categoryId,
                             @Param("name") String name,
                             @Param("description") String description,
                             @Param("urgency") String urgency,
                             @Param("status") String status,
                             @Param("createdByUser") int createdByUser
                            ) throws PersistenceException;



    public void updateStatus(int id,String status) throws PersistenceException;



    /**
     * Get the Need by its name
     * @param name The offer's name
     * @return
     * @throws PersistenceException
     */
    public Need getNeedByName(String name) throws PersistenceException;

    /**
     * Get the Need by its id
     * @param id
     * @return
     * @throws PersistenceException
     */
    public Need getNeedByID(int id) throws PersistenceException;

    public List<Need> getAllNeeds() throws PersistenceException;

    public void deleteNeed(int needId) throws PersistenceException;


}
