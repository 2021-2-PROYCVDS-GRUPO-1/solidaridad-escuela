package edu.eci.cvds.persistence.mybatis;

import edu.eci.cvds.entities.Category;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatis.dao.CategoryDAO;
import edu.eci.cvds.persistence.mybatis.mappers.CategoryMapper;

import javax.inject.Inject;

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
    public Category getCategoryId(String id) throws PersistenceException {
        try{
            return categoryMapper.getCategoryId(id);
        }catch (PersistenceException e) {
            throw  new PersistenceException("Error al consultar la categoria con el id: "+ id);
        }
    }
    /**
    @Override
    public void upCategoryId(String id, String name, String description, String state) throws PersistenceException {
        try{
            categoryMapper.updCategoryId(id, name, description, state);
        } catch(PersistenceException e) {
            throw  new PersistenceException("Error al actualizar la categoria con el id: "+ id);
        }
    }*/
}
