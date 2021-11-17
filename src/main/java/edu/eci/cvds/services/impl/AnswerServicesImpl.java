package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatis.dao.AnswerDAO;
import edu.eci.cvds.services.AnswerServices;
import edu.eci.cvds.services.ServicesException;

public class AnswerServicesImpl implements AnswerServices {
    @Inject
    private AnswerDAO answerDAO;

    @Override
    public void addAnswer(String name, String comments, int idOffer, int idNeeds) throws ServicesException {
        try{
            answerDAO.addAnswer(name, comments, idOffer, idNeeds);
        }catch (PersistenceException e) {
            throw  new ServicesException("Error al añadir la respuesta con el nombre: "+ name);
        }
    }
}
