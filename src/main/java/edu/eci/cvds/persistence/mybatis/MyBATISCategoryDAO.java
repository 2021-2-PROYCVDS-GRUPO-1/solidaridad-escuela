package edu.eci.cvds.persistence.mybatis;

import edu.eci.cvds.entities.Category;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatis.dao.CategoryDAO;
import edu.eci.cvds.persistence.mybatis.mappers.CategoryMapper;

import javax.inject.Inject;
import java.util.List;

/**
 * @author Laura Valentina García León
 * @author Laura Nathalia García
 * @author Juan Sebastián Cadavid
 * @author Juan David Murillo
 * @version 19/10/2021
 */
public class MyBATISCategoryDAO implements CategoryDAO {
    @Inject
    private CategoryMapper categoryMapper ;

    @Override
    public Category getCategoryName(String name) throws PersistenceException {
        try{
            return categoryMapper.getCategoryName(name);
        }catch (PersistenceException e) {
            throw  new PersistenceException("Error al consultar la categoria con el nombre: "+ name);
        }
    }

    @Override
    public Category getCategoryId(int id) throws PersistenceException {
        try{
            return categoryMapper.getCategoryId(id);
        }catch (PersistenceException e) {
            throw  new PersistenceException("Error al consultar la categoria con el id: "+ id);
        }
    }

    @Override
    public List<Category> getAllCategories() throws PersistenceException {
        try{
            return categoryMapper.getAllCategories();
        }catch (PersistenceException e) {
            throw new PersistenceException("Error al consultar la lista de categorías: ");
        }
    }

    @Override
    public void addCategory(String name, String description, String state) throws PersistenceException {
        try{
            categoryMapper.addCategory(name, description, state);
        } catch(PersistenceException e) {
            throw  new PersistenceException("Error al añadir la categoria con el nombre: "+ name);
        }
    }

    @Override
     public void upCategoryId(int id, String name, String description, String state) throws PersistenceException {
         try{
            categoryMapper.upCategoryId(id, name, description, state);
         } catch(PersistenceException e) {
            throw  new PersistenceException("Error al actualizar la categoria con el id: "+ id);
         }
     }

    @Override
    public void upCategoryName(String name, String description, String state) throws PersistenceException {
        try{
            categoryMapper.upCategoryName(name, description, state);
        } catch(PersistenceException e) {
            throw  new PersistenceException("Error al actualizar la categoria con el name: "+ name);
        }
    }

    @Override
    public List<Category> getCategories() throws PersistenceException {
        try {
            return categoryMapper.getCategories();
        }catch (PersistenceException e){
            throw new PersistenceException("Error al consultar Categorias");
        }
    }

    @Override
    public void deleteCategory(int categoryId) throws PersistenceException {
        try {
            categoryMapper.deleteCategory(categoryId);
        }catch (PersistenceException e){
            throw new PersistenceException("Error al eliminar la categoría");
        }
    }


}
