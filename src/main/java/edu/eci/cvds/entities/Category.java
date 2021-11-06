package edu.eci.cvds.entities;

import java.util.Date;

/**
 * @author Laura Valentina García León
 * @author Laura Nathalia García
 * @author Juan Sebastián Cadavid
 * @author Juan David Murillo
 * @version 19/10/2021
 */
public class Category {
    private int id;
    private String name;
    private String description;
    private Date dateCreate;
    private String state;
    private Date dateModification;

    public Category(){}

    /**
     * Constructor object type Category
     * @param id Identification of objects
     * @param name name of category
     * @param description short category summary
     * @param dateCreate creation start date
     * @param state what state is the category in
     * @param dateModification date of the last modification
     */
    public Category(int id, String name, String description, Date dateCreate, String state, Date dateModification) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateCreate = dateCreate;
        this.state = state;
        this.dateModification = dateModification;
    }

    public Category(String name, String description, String state) {
        this.name = name;
        this.description = description;
        this.state = state;
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

    public Date getDateCreate() {
        return dateCreate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }
}
