package edu.eci.cvds.persistence.mybatis.dao;

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
public interface CategoryDAO {
    /**
     * Get the Category by its name
     * @param name The name of category
     * @return
     * @throws PersistenceException
     */
    public Category getCategoryName(String name) throws PersistenceException;

    /**
     * Get the Category by its id
     * @param id The id of category
     * @return
     * @throws PersistenceException
     */
    public Category getCategoryId(int id) throws PersistenceException;

    public List<Category> getAllCategories() throws PersistenceException;


    public void addCategory(@Param("name") String name,
                            @Param("description") String description,
                            @Param("state") String state) throws PersistenceException;

    public void  upCategoryId(int id, String name, String description, String state) throws PersistenceException;

    public void upCategoryName(String name, String description, String state) throws PersistenceException;


    public List<Category> getCategories() throws PersistenceException;

    public void deleteCategory(int categoryId) throws PersistenceException;
}
