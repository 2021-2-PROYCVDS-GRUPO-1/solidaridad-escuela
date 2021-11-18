package edu.eci.cvds.services;

import edu.eci.cvds.entities.Need;
import edu.eci.cvds.persistence.PersistenceException;

public interface NeedServices {

    /**
     * INSERT
     */
    public void registerNeed(String name,
                             String description,
                             String status,
                             int categoryId,
                             String urgency,
                             int createdByUser) throws ServicesException;


    /**
     * UPDATE STATE
     * @param named
     * @param state
     * @throws ServicesException
     */
    public void updateStatus(String name, String state) throws ServicesException;

    //public Need getNeedByID(int id) throws ServicesException;

    //public Need getNeedByName(String name) throws ServicesException;

}
