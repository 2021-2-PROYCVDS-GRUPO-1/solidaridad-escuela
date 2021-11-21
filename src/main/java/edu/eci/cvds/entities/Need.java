package edu.eci.cvds.entities;

import java.util.Date;

/**
 * @author Laura Valentina García León
 * @author Laura Nathalia García
 * @author Juan Sebastián Cadavid
 * @author Juan David Murillo
 * @version 19/10/2021
 */

public class Need {

    private int id;
    private int category;
    private String name;
    private String description;
    private String urgency;
    private Date creationDate;
    private String status;
    private Date modificationDate;
    private String createdByUser;

    private Need(){
    }

    public Need(int id, int category, String name, String description, String urgency, Date creationDate, String status, Date modificationDate, String createdByUser) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.description = description;
        this.urgency = urgency;
        this.creationDate = creationDate;
        this.status = status;
        this.modificationDate = modificationDate;
        this.createdByUser = createdByUser;
    }

    public Need(int id, int category, String name, String description, String urgency, Date creationDate, String status, Date modificationDate) {

        this.id = id;
        this.category = category;
        this.name = name;
        this.description = description;
        this.urgency = urgency;
        this.creationDate = creationDate;
        this.status = status;
        this.modificationDate = modificationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public String getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(String createdByUser) {
        this.createdByUser = createdByUser;
    }
}
