package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Answer;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatis.dao.AnswerDAO;
import edu.eci.cvds.services.AnswerServices;
import edu.eci.cvds.services.ServicesException;

import java.util.List;

public class AnswerServicesImpl implements AnswerServices {
    @Inject
    private AnswerDAO answerDAO;

    @Override
    public List<Answer> getAnsOfferNeed() throws ServicesException {
        try{
            return answerDAO.getAnsOfferNeed();
        }catch (PersistenceException e) {
            throw  new ServicesException("Error al traer las respuestas");
        }
    }

    @Override
    public void addAnswer(String name, String comments, int idOffer, int idNeeds, int userId) throws ServicesException {
        try{
            answerDAO.addAnswer(name, comments, idOffer, idNeeds, userId);
        }catch (PersistenceException e) {
            throw  new ServicesException("Error al añadir la respuesta con el nombre: "+ name);
        }
    }

    @Override
    public void addAnswerOffer(String name, String comments, int idOffer, int userId) throws ServicesException {
        try{
            answerDAO.addAnswerOffer(name, comments, idOffer, userId);
        }catch (PersistenceException e) {
            throw  new ServicesException("Error al añadir la respuesta con el nombre: "+ name);
        }
    }

    @Override
    public void addAnswerNeeds(String name, String comments, int idNeeds, int userId) throws ServicesException {
        try{
            answerDAO.addAnswerNeeds(name, comments, idNeeds, userId);
        }catch (PersistenceException e) {
            throw  new ServicesException("Error al añadir la respuesta con el nombre: "+ name);
        }
    }
}
