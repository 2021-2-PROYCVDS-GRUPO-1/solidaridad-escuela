package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Need;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatis.dao.NeedDAO;
import edu.eci.cvds.services.Services;
import edu.eci.cvds.services.ServicesException;

/**
 * @author Laura Valentina García León
 * @author Laura Nathalia García
 * @author Juan Sebastián Cadavid
 * @author Juan David Murillo
 * @version 17/10/2021
 */
public class ServicesImpl implements Services {

    @Inject
    private NeedDAO needDAO;

    @Override
    public void testMethod() throws ServicesException {

    }




}
