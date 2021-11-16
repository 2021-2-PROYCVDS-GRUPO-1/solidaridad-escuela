package edu.eci.cvds.managedbeans;

import edu.eci.cvds.services.CategoryServices;
import edu.eci.cvds.services.ServicesException;
import edu.eci.cvds.utils.DatabaseStatus;
import org.checkerframework.checker.units.qual.A;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "categoryBean")
@ApplicationScoped
public class CategoryBean extends BasePageBean{
    @Inject
    private CategoryServices categoryServices;

    private String name;
    private String description;
    private String state;
    private List<String> statusList;

    @PostConstruct
    public void init(){
        statusList = new ArrayList<>();

        categoryServices = getInjector().getInstance(CategoryServices.class);

        System.out.println("  ");
        System.out.println("  ");
        System.out.println("---- CATEGORY SERVICES ----");
        System.out.println(categoryServices);
        System.out.println("  ");
        System.out.println("  ");

        try{
            for(DatabaseStatus status : DatabaseStatus.values()){
                System.out.println(status.toString());
                statusList.add(status.toString());
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    public void createCategory() {
        try{
            System.out.println("Anadiendo categoría con nombre: " + this.name
            + "\nDescripcion: " + this.description
            + "\nEstado: " + this.state);

            categoryServices.addCategory(this.name, this.description, this.state);
        }catch(Exception e){
            e.printStackTrace();
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

    public List<String> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<String> statusList) {
        this.statusList = statusList;
    }

    public CategoryServices getCategoryServices() {
        return categoryServices;
    }

    public void setCategoryServices(CategoryServices categoryServices) {
        this.categoryServices = categoryServices;
    }
}

