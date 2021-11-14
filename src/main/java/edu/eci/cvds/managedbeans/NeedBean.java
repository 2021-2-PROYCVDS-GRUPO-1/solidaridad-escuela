package edu.eci.cvds.managedbeans;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Category;
import edu.eci.cvds.entities.Need;
import edu.eci.cvds.services.NeedServices;
import edu.eci.cvds.services.ServicesException;


import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;

@ManagedBean(name = "needBean")
@ApplicationScoped
public class NeedBean extends BasePageBean{
    @Inject
    private NeedServices needServices;

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
