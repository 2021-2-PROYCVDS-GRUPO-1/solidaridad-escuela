package edu.eci.cvds.persistence.mybatis.mappers;

import edu.eci.cvds.entities.Category;
import edu.eci.cvds.persistence.PersistenceException;
import org.apache.ibatis.annotations.Param;

/**
 * @author Laura Valentina García León
 * @author Laura Nathalia García
 * @author Juan Sebastián Cadavid
 * @author Juan David Murillo
 * @version 19/10/2021
 */
public interface CategoryMapper {
    public Category getCategoryId(@Param("id") String id) throws PersistenceException;

    public Category getCategoryName(@Param("name") String name) throws PersistenceException;
}
