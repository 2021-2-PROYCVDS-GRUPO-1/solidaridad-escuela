package edu.eci.cvds.entities;

import java.util.Date;

public class Answer {
    private int id;
    private int idOffer;
    private int idNeeds;
    private int userId;
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

    public Answer(String name, String comments, String nameOfferORNeed) {
        this.name = name;
        this.comments = comments;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
