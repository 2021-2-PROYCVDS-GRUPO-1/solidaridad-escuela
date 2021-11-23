package edu.eci.cvds.services;

import edu.eci.cvds.entities.Need;
import edu.eci.cvds.persistence.PersistenceException;

import java.util.HashMap;
import java.util.List;

public interface NeedServices {

    // CREATE
    public void registerNeed(int categoryId,
                             String name,
                             String description,
                             String urgency,
                             String status,
                             int createdByUser) throws ServicesException;

    // READ
    public List<Need> getAllNeeds() throws ServicesException;

    // UPDATE
    public void updateStatus(int id, String state) throws ServicesException;

    // DELETE
    public void deleteNeed (int needId) throws ServicesException;
}
