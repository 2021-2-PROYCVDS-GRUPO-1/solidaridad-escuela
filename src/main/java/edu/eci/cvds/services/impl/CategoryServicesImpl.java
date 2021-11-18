package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Category;
import edu.eci.cvds.entities.Offer;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatis.dao.CategoryDAO;
import edu.eci.cvds.services.CategoryServices;
import edu.eci.cvds.services.ServicesException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryServicesImpl implements CategoryServices {
    @Inject
    private CategoryDAO categoryDAO;

    @Override
    public Category getCategoryName(String name) throws ServicesException {
        try{
            return categoryDAO.getCategoryName(name);
        }catch (PersistenceException e) {
            throw  new ServicesException("Error al consultar la categoria con el nombre: "+ name);
        }
    }

    @Override
    public Category getCategoryId(int id) throws ServicesException {
        try{
            return categoryDAO.getCategoryId(id);
        }catch (PersistenceException e) {
            throw  new ServicesException("Error al consultar la categoria con el id: "+ id);
        }
    }

    @Override
    public void addCategory(String name, String description, String state) throws ServicesException {
        try{
            categoryDAO.addCategory(name, description, state);
        } catch(PersistenceException e) {
            throw  new ServicesException("Error al añadir la categoria con el nombre: "+ name);
        }
    }

    @Override
    public void upCategoryId(int id, String name, String description, String state) throws ServicesException {
        try{
            categoryDAO.upCategoryId(id, name, description, state);
        } catch(PersistenceException e) {
            throw  new ServicesException("Error al actualizar la categoria con el id: "+ id);
        }
    }

    @Override
    public void upCategoryName(String name, String description, String state) throws ServicesException {
        try{
            categoryDAO.upCategoryName(name, description, state);
        } catch(PersistenceException e) {
            throw  new ServicesException("Error al actualizar la categoria con el name: "+ name);
        }
    }



    @Override
    public HashMap<String, Integer> getCategories()  {
        HashMap<String, Integer> finalList = new HashMap<String, Integer>();
        try{

            List<Category> newlist = categoryDAO.getCategories();
            for(int i = 0; i <  newlist.size(); i++){
                finalList.put(newlist.get(i).getName(), newlist.get(i).getId());

        }

        } catch(PersistenceException e) {
            System.out.println(e.getMessage());
        }
        return  finalList;
    }




}
