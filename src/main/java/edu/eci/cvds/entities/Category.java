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
    private Long offer;
    private Long need;
    private Long total;
    private String name;
    private String description;
    private String state;
    private Date date_Create;
    private Date date_Modification;

    public Category(){}

    /**
     * Constructor object type Category
     * @param id Identification of objects
     * @param name name of category
     * @param description short category summary
     * @param date_Create creation start date
     * @param state what state is the category in
     * @param date_Modification date of the last modification
     */
    public Category(int id, String name, String description, Date date_Create, String state, Date date_Modification) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date_Create = date_Create;
        this.state = state;
        this.date_Modification = date_Modification;
    }

    public Category(String name, String description, String state) {
        this.name = name;
        this.description = description;
        this.state = state;
    }

    public Category(String name, Long offer, Long need, Long total) {
        this.offer = offer;
        this.need = need;
        this.name = name;
        this.total = total;
    }

    public Long getOffer() {
        return offer;
    }

    public void setOffer(Long offer) {
        this.offer = offer;
    }

    public Long getNeed() {
        return need;
    }

    public void setNeed(Long need) {
        this.need = need;
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
        return date_Create;
    }

    public String getDescription() {
        return description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Date getDate_Create() {
        return date_Create;
    }

    public void setDate_Create(Date date_Create) {
        this.date_Create = date_Create;
    }

    public Date getDate_Modification() {
        return date_Modification;
    }

    public void setDate_Modification(Date date_Modification) {
        this.date_Modification = date_Modification;
    }
}
