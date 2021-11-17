package edu.eci.cvds.services;

import edu.eci.cvds.entities.Need;

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
}
