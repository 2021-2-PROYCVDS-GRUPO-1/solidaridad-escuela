package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Need;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatis.dao.NeedDAO;
import edu.eci.cvds.services.NeedServices;
import edu.eci.cvds.services.ServicesException;

public class NeedServicesImpl implements NeedServices {
    @Inject private NeedDAO needDAO;

    @Override
    public void registerNeed(Need need) throws ServicesException {
        try{
            needDAO.save(need);
        }catch(PersistenceException exception){
            throw new ServicesException(exception.getMessage(),exception);
        }
    }
}
