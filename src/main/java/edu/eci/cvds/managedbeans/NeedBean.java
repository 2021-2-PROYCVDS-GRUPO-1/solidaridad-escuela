package edu.eci.cvds.managedbeans;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Category;
import edu.eci.cvds.entities.Need;
import edu.eci.cvds.services.NeedServices;
import edu.eci.cvds.services.ServicesException;
import edu.eci.cvds.utils.DatabaseStatus;
import edu.eci.cvds.utils.Urgency;


import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean(name = "needBean")
@ApplicationScoped
public class NeedBean extends BasePageBean{
    @Inject
    private NeedServices needServices;

    private int id;
    private int category;
    private String name;
    private String description;
    private String urgency;
    private Date creationDate;
    private String status;
    private Date modificationDate;
    private int createdByUser;

    private List<String> statusList;
    private List<Category> categoryList;
    private List<String> urgencyList;

    @PostConstruct
    public void init(){
        System.out.println("edu.eci.cvds.managedbeans.NeedBean.init()");

        statusList = new ArrayList<>();
        categoryList = new ArrayList<>();
        urgencyList = new ArrayList<>();

        try{
            // Status
            for(DatabaseStatus status : DatabaseStatus.values()){
                statusList.add(status.toString());
            }

            // Urgency
            for(Urgency myUrgency : Urgency.values()){
                urgencyList.add(myUrgency.toString());
            }

            // TODO: Categories -> ¿cómo hago un fetch?
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void registerNeed(){
        System.out.println("edu.eci.cvds.managedbeans.NeedBean.registerNeed()");

        // TODO -> Traer el id del usuario que necesito
        int testUser = 0;

        try{
            System.out.println("Anadiendo necesidad con con nombre: " + this.name
                    + "\nDescripcion: " + this.description
                    + "\nEstado: " + this.status
                    + "\nCategoría: " + this.category
                    + "\nUrgencia: " + this.urgency
                    + "\nPor el usuario: " + testUser
                    );

            needServices.registerNeed(this.name,
                    this.description,
                    this.status,
                    this.category,
                    this.urgency,
                    0);
        }catch(Exception e){
            e.printStackTrace();
        }
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

    public int getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(int createdByUser) {
        this.createdByUser = createdByUser;
    }

    public List<String> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<String> statusList) {
        this.statusList = statusList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<String> getUrgencyList() {
        return urgencyList;
    }

    public void setUrgencyList(List<String> urgencyList) {
        this.urgencyList = urgencyList;
    }
}
