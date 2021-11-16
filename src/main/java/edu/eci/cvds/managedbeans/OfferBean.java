package edu.eci.cvds.managedbeans;


import edu.eci.cvds.services.OfferServices;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Laura Valentina García León
 * @author Laura Nathalia García
 * @author Juan Sebastián Cadavid
 * @author Juan David Murillo
 * @version 4/11/2021
 */

@ManagedBean(name = "offerBean")
@SessionScoped


public class OfferBean extends BasePageBean{
    @Inject
    private OfferServices offerServices;

    //private int offerId;
    private int offerCategory;
    private String name;
    private String description;
    private String status;
    private int userId;







    public void createOffer(){
        userId = 1001184238;
        System.out.println(offerCategory + " " + name + " " + description + " " + userId );
        try{
            offerServices.createOffer(offerCategory, name, description, userId);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void changeStatus(){
        status = "SOLVED";
        try{
            offerServices.changeStatus(name, status);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public OfferServices getOfferServices() { return offerServices; }

    public void setOfferServices(OfferServices offerServices) { this.offerServices = offerServices; }

    public int getOfferCategory() { return offerCategory; }

    public void setOfferCategory(int offerCategory) { this.offerCategory = offerCategory; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public int getUserId() { return userId; }

    public void setUserId(int userId) { this.userId = userId; }
}
