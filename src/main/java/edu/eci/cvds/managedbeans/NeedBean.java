package edu.eci.cvds.managedbeans;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Category;
import edu.eci.cvds.entities.Need;
import edu.eci.cvds.services.NeedServices;
import edu.eci.cvds.services.ServicesException;


import java.util.ArrayList;


public class NeedBean extends BasePageBean{
    @Inject private NeedServices needServices;
    private Need need;
    ArrayList<Category> categories = new ArrayList<Category>();



    public  void registerNeed(){
        try{
            if(categories.contains(need.getCategory())) {
                needServices.registerNeed(need);

            }
        } catch (ServicesException exception){
            exception.printStackTrace();

        }
    }

}
