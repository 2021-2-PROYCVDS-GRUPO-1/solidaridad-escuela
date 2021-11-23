package edu.eci.cvds.services;

import edu.eci.cvds.entities.Need;
import edu.eci.cvds.persistence.PersistenceException;

import java.util.HashMap;
import java.util.List;

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
     * @param id
     * @param state
     * @throws ServicesException
     */
    public void updateStatus(int id, String state) throws ServicesException;

    /*
    DELETE
     */
    public void deleteNeed (int needId) throws ServicesException;

    public List<Need> getAllNeeds() throws ServicesException;

    //public Need getNeedByID(int id) throws ServicesException;

    //public Need getNeedByName(String name) throws ServicesException;

}
