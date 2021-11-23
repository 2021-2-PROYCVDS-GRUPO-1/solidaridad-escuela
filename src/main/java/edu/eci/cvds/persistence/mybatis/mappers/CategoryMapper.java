package edu.eci.cvds.persistence.mybatis.mappers;

import edu.eci.cvds.entities.Category;
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
public interface CategoryMapper {
    public Category getCategoryId(@Param("id") int id) throws PersistenceException;

    public Category getCategoryName(@Param("name") String name) throws PersistenceException;

    public List<Category> getAllCategories() throws PersistenceException;

    public List<Category> getCategories() throws PersistenceException;

    public void addCategory(@Param("name") String name,
                            @Param("description") String description,
                            @Param("state") String state) throws PersistenceException;

    public void upCategoryId(@Param("id") int id,
                              @Param("name") String name,
                              @Param("description") String description,
                              @Param("state") String state) throws PersistenceException;

    public void upCategoryName(@Param("name") String name,
                                @Param("description") String description,
                                @Param("state") String state) throws PersistenceException;

    public void deleteCategory(@Param("id") int id) throws PersistenceException;

}
