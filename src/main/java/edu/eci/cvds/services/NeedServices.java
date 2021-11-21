package edu.eci.cvds.services;

import edu.eci.cvds.entities.Need;
import edu.eci.cvds.persistence.PersistenceException;

import java.util.HashMap;

public interface NeedServices {

    /**
     * INSERT
     */
    public void registerNeed(int categoryId,
                             String name,
                             String description,
                             String urgency,
                             String status,
                             int createdByUser) throws ServicesException;


    /**
     * UPDATE STATE
     * @param name
     * @param state
     * @throws ServicesException
     */
    public void updateStatus(String name, String state) throws ServicesException;

    public HashMap<Integer, String> getNeeds();

    //public Need getNeedByID(int id) throws ServicesException;

    //public Need getNeedByName(String name) throws ServicesException;

}
