package edu.eci.cvds.entities;

import java.util.Date;

public class Answer {
    private int id;
    private int idOffer;
    private int idNeeds;
    private String name;
    private String comments;
    private String nameOfferORNeed;
    private Date dateCreate;

    public Answer(){}

    public Answer(String name, String comments, int idOffer, int idNeeds) {
        this.name = name;
        this.comments = comments;
        this.idOffer = idOffer;
        this.idNeeds = idNeeds;
    }

    public Answer(int id, String name, String comments, Date dateCreate, String nameOfferORNeed) {
        this.id = id;
        this.name = name;
        this.comments = comments;
        this.dateCreate = dateCreate;
        this.nameOfferORNeed = nameOfferORNeed;
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

    public String getNameOfferORNeed() {
        return nameOfferORNeed;
    }

    public void setNameOfferORNeed(String nameOfferORNeed) {
        this.nameOfferORNeed = nameOfferORNeed;
    }

    public void setIdNeeds(int idNeeds) {
        this.idNeeds = idNeeds;
    }
}
