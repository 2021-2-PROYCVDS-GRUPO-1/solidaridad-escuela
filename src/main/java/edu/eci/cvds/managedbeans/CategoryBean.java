package edu.eci.cvds.managedbeans;

import edu.eci.cvds.entities.Category;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.services.CategoryServices;
import edu.eci.cvds.services.ServicesException;
import edu.eci.cvds.utils.DatabaseStatus;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.checkerframework.checker.units.qual.A;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.sql.SQLOutput;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean(name = "categoryBean")
@ApplicationScoped
public class CategoryBean extends BasePageBean{
    @Inject
    private CategoryServices categoryServices;
    
    private int id;
    private int userId;
    private String name;
    private String description;
    private String state;
    private String dateCreate;
    private String dateModification;
    private String userRole;
    private List<String> statusList;
    private List<Category> allCategories;
    private Category categoryToEdit;

    @PostConstruct
    public void init(){
        System.out.println("edu.eci.cvds.managedbeans.CategoryBean.init()");

        statusList = new ArrayList<>();

        getUserInformation();

        // TODO -> crear una funcion que genere los servicios, como en OfferBean
        categoryServices = getInjector().getInstance(CategoryServices.class);
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

    private void getUserInformation(){
        System.out.println("edu.eci.cvds.managedbeans.CategoryBean.getUserInformation()");

        Subject subject = SecurityUtils.getSubject();
        this.userId = (int) subject.getSession().getAttribute("userId");
        this.userRole = (String) subject.getSession().getAttribute("role");
    }

    public void createCategory() {
        System.out.println("edu.eci.cvds.managedbeans.CategoryBean.createCategory()");

        try{
            categoryServices.addCategory(this.name, this.description, this.state);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/categoryList.xhtml");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void updateCategory() throws ServicesException {
        System.out.println("edu.eci.cvds.managedbeans.CategoryBean.updateCategory()");

        try{
            categoryServices.upCategoryId(id, name, description, state);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/categoryList.xhtml");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteCategory(Category categoryToDelete) {
        System.out.println("edu.eci.cvds.managedbeans.CategoryBean.deleteCategory()");

        try{
            categoryServices.deleteCategory(categoryToDelete.getId());
            FacesContext.getCurrentInstance().getExternalContext().redirect("/categoryList.xhtml");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void getCategoryList(){
        System.out.println("edu.eci.cvds.managedbeans.CategoryBean.getCategoryList()");

        try {
            this.allCategories = categoryServices.getAllCategories();

            for(Category category : this.allCategories){
                System.out.println(category.getName());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void goToUpdateCategory(Category category) {
        System.out.println("edu.eci.cvds.managedbeans.CategoryBean.goToUpdateCategory()");

        System.out.println("   ");
        System.out.println("   ");
        System.out.println("Editando la categoría: " + category.getName());
        System.out.println("   ");
        System.out.println("   ");

        this.categoryToEdit = category;

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/updateCategory.xhtml");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void verifyValidUpdate(){
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-M-dd");

            if (this.categoryToEdit.getId() >= 0){
                this.id = this.categoryToEdit.getId();
                this.state = this.categoryToEdit.getState();
                this.name = this.categoryToEdit.getName();
                this.description = this.categoryToEdit.getDescription();
                this.dateCreate = dateFormat.format(this.categoryToEdit.getDateCreate());
                this.dateModification = dateFormat.format(this.categoryToEdit.getDateModification());
            }

            this.categoryToEdit = null;
        } catch (Exception e){
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/categoryList.xhtml");
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    public void verifyIfUserHasAccess() {
        System.out.println("edu.eci.cvds.managedbeans.CategoryBean.verifyIfUserHasAccess()");

        if (this.userRole.equals("ADMIN")){
            this.getCategoryList();
            return;
        }

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/mainMenu.xhtml");
        } catch (Exception ex){
            ex.printStackTrace();
        }
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

    public List<Category> getAllCategories() {
        return allCategories;
    }

    public void setAllCategories(List<Category> allCategories) {
        this.allCategories = allCategories;
    }

    public Category getCategoryToEdit() {
        return categoryToEdit;
    }

    public void setCategoryToEdit(Category categoryToEdit) {
        this.categoryToEdit = categoryToEdit;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getDateModification() {
        return dateModification;
    }

    public void setDateModification(String dateModification) {
        this.dateModification = dateModification;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

