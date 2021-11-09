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
    private int offerId;
    private String offerCategory;
    private String name;
    private String description;
    private String status;
    private Date dateCreate;
    private Date dateModification;
    private int userId;
    private int maxneeds;

    public Offer(){}

    public Offer(int offerId, String offerCategory, String name, String description, Date dateCreate, Date dateModification){
        this.offerId = offerId;
        this.offerCategory = offerCategory;
        this.name = name;
        this.description = description;
        this.status = status;
        this.dateCreate = dateCreate;
        this.dateModification = dateModification;
    }

    public int getOfferId() { return offerId; }

    public void setOfferId(int offerId) { this.offerId = offerId; }

    public String getOfferCategory() { return offerCategory; }

    public void setOfferCategory(String offerCategory) { this.offerCategory = offerCategory; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public Date getDateCreate() { return dateCreate; }

    public void setDateCreate(Date dateCreate) { this.dateCreate = dateCreate; }

    public Date getDateModification() { return dateModification; }

    public void setDateModification(Date dateModification) { this.dateModification = dateModification; }

    public int getUserId() { return userId; }

    public void setUserId(int userId) { this.userId = userId; }

    public int getMaxneeds() { return maxneeds; }

    public void setMaxneeds(int maxneeds) { this.maxneeds = maxneeds; }
}


