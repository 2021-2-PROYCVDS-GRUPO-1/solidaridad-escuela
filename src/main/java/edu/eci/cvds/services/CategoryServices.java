package edu.eci.cvds.services;

import edu.eci.cvds.entities.Category;
import edu.eci.cvds.persistence.PersistenceException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Laura Valentina García León
 * @author Laura Nathalia García
 * @author Juan Sebastián Cadavid
 * @author Juan David Murillo
 * @version 28/10/2021
 */
public interface CategoryServices {
    /*
    SELECT
     */

    public Category getCategoryName(String name) throws ServicesException;
    public Category getCategoryId(int id) throws ServicesException;
    public List<Category> getAllCategories() throws ServicesException;
    public HashMap<String, Integer> getCategories() throws ServicesException;;
    public List<Category> getReportCategory() throws ServicesException;;

    /*
    INSERT
     */
    public void addCategory(String name, String description, String state) throws ServicesException;

    /*
    UPDATE
     */

    public void upCategoryId(int id, String name, String description, String state) throws ServicesException;
    public void upCategoryName(String name, String description, String state) throws ServicesException;


    /*
    DELETE
     */
    public void deleteCategory(int categoryId) throws ServicesException;


}
