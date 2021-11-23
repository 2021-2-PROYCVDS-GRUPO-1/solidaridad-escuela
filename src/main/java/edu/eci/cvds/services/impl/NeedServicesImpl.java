package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Need;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatis.dao.NeedDAO;
import edu.eci.cvds.services.NeedServices;
import edu.eci.cvds.services.ServicesException;

import java.util.HashMap;
import java.util.List;

public class NeedServicesImpl implements NeedServices {
    @Inject private NeedDAO needDAO;

    // CREATE
    @Override
    public void registerNeed(int categoryId,
                             String name,
                             String description,
                             String urgency,
                             String status,
                             int createdByUser) throws ServicesException {
        try{
            needDAO.addNecessity(categoryId,
                    name,
                    description,
                    urgency,
                    status,
                    createdByUser);
        }catch(PersistenceException exception){
            throw new ServicesException(exception.getMessage(),exception);
        }
    }

    // READ
    @Override
    public List<Need> getAllNeeds() throws ServicesException {
        try {
            return needDAO.getAllNeeds();
        }catch (PersistenceException exception){
            throw new ServicesException(exception.getMessage(),exception);
        }
    }

    // UPDATE
    @Override
    public void updateStatus(int id, String status) throws ServicesException {
        try {
            needDAO.updateStatus(id,status);
        }catch (PersistenceException exception){
            throw new ServicesException(exception.getMessage(),exception);
        }
    }

    // DELETE
    @Override
    public void deleteNeed(int needId) throws ServicesException {
        try {
            needDAO.deleteNeed(needId);
        }catch (PersistenceException exception){
            throw new ServicesException(exception.getMessage(),exception);
        }
    }




}
