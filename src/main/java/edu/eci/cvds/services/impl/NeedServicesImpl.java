package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Need;
import edu.eci.cvds.entities.Offer;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatis.dao.NeedDAO;
import edu.eci.cvds.services.NeedServices;
import edu.eci.cvds.services.ServicesException;

import java.util.HashMap;

public class NeedServicesImpl implements NeedServices {
    @Inject private NeedDAO needDAO;

    @Override
    public void registerNeed(String name,
                             String description,
                             String status,
                             int categoryId,
                             String urgency,
                             int createdByUser) throws ServicesException {
        try{
            needDAO.addNecessity(name,
                    description,
                    status,
                    categoryId,
                    urgency,
                    createdByUser);
        }catch(PersistenceException exception){
            throw new ServicesException(exception.getMessage(),exception);
        }
    }

    @Override
    public void updateStatus(String name, String status) throws ServicesException{
        try {
            needDAO.updateStatus(name,status);
        }catch (PersistenceException exception){
            throw new ServicesException(exception.getMessage(),exception);
        }
    }

    @Override
    public HashMap<Integer, String> getNeeds() {
        HashMap<Integer, String> listNeed = new HashMap<Integer, String>();
        try{
            for(Need newlist: needDAO.getNeeds()) {
                if((newlist.getStatus().equals("ACTIVE")) || (newlist.getStatus().equals( "IN PROCESS"))){
                    listNeed.put(newlist.getId(), newlist.getName());
                }
            }
        } catch(PersistenceException e) {
            System.out.println(e.getMessage());
        }
        return listNeed;
    }

}
