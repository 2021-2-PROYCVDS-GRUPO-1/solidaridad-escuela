package edu.eci.cvds.managedbeans;

import edu.eci.cvds.services.CategoryServices;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

@ManagedBean(name = "categoryBean")
@ApplicationScoped
public class CategoryBean extends BasePageBean{
    @Inject
    private CategoryServices categoryServices;

    private String name;
    private String description;
    private String state;

    public void createCategory() {
        state="completo";
        System.out.println(name+" "+state+" "+description);
        try{
            categoryServices.addCategory(name, description, state);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

