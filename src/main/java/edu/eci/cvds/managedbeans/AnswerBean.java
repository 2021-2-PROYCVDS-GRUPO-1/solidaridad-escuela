package edu.eci.cvds.managedbeans;

import edu.eci.cvds.services.AnswerServices;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import java.util.Date;

@ManagedBean(name = "answerBean")
@ApplicationScoped
public class AnswerBean extends BasePageBean{
    @Inject
    private AnswerServices answerServices;

    private int id;
    private String name;
    private String comments;
    private Date dateCreate;
    private int idOffer;
    private int idNeeds;

    public void createAnswer() {
        try{
            answerServices.addAnswer(name, comments, idOffer, idNeeds);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public AnswerServices getAnswerServices() {
        return answerServices;
    }

    public void setAnswerServices(AnswerServices answerServices) {
        this.answerServices = answerServices;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public int getIdOffer() {
        return idOffer;
    }

    public void setIdOffer(int idOffer) {
        this.idOffer = idOffer;
    }

    public int getIdNeeds() {
        return idNeeds;
    }

    public void setIdNeeds(int idNeeds) {
        this.idNeeds = idNeeds;
    }
}
