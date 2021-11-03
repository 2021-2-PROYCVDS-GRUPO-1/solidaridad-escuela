package edu.eci.cvds.services;

import edu.eci.cvds.entities.Need;

public interface NeedServices {

    public void registerNeed(Need need) throws ServicesException;

}
