package edu.eci.cvds.managedbeans;

import edu.eci.cvds.entities.Category;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "categoryBean")
@ApplicationScoped
public class CategoryBean {

    private String name;
    private String description;
    private String state;

    public void createCategoryBean(String name, String description) {
        System.out.println("----------------------------holi-----------------------------------------");
        System.out.println(name+" "+description);
        this.name = name;
        this.description = description;
        state="incompleto";
        Category category = new Category(this.name, this.description, this.state);

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

