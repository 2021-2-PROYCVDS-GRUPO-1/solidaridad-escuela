package edu.eci.cvds.managedbeans;


import edu.eci.cvds.services.OfferServices;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.xml.bind.SchemaOutputResolver;

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

    private int offerId;
    private String offerCategory;
    private String name;
    private String description;
    private String status;

    public void registrarOferta(){
        try{
            offerServices.registrarOferta(offerId, offerCategory, name, description);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }






}
