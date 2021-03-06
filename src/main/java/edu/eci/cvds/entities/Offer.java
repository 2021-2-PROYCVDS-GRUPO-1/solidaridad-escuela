package edu.eci.cvds.entities;

import java.util.Date;

/**
 * @author Laura Valentina García León
 * @author Laura Nathalia García
 * @author Juan Sebastián Cadavid
 * @author Juan David Murillo
 * @version 19/10/2021
 */
public class Offer {
    private int userId;
    private int offerId;
    private int offerCategory;


    private String name;
    private String status;
    private String description;


    private Date dateCreation;
    private Date dateModification;


    /* ----- TEMPORAL ------ */
    private String userName;
    private String categoryName;


    public Offer(){}

    public Offer(int offerId, int offerCategory, String name, String description, Date dateCreate, Date dateModification){
        this.offerId = offerId;
        this.offerCategory = offerCategory;
        this.name = name;
        this.description = description;
        this.status = status;
        this.dateCreation = dateCreate;
        this.dateModification = dateModification;
    }

    public int getOfferId() { return offerId; }

    public void setOfferId(int offerId) { this.offerId = offerId; }

    public int getOfferCategory() { return offerCategory; }

    public void setOfferCategory(int offerCategory) { this.offerCategory = offerCategory; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public Date getDateCreation() { return dateCreation; }

    public void setDateCreation(Date dateCreate) { this.dateCreation = dateCreate; }

    public Date getDateModification() { return dateModification; }

    public void setDateModification(Date dateModification) { this.dateModification = dateModification; }

    public int getUserId() { return userId; }

    public void setUserId(int userId) { this.userId = userId; }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}


