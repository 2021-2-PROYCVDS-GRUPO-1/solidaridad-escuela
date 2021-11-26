package edu.eci.cvds.managedbeans;

import edu.eci.cvds.entities.Category;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.services.CategoryServices;
import edu.eci.cvds.services.ServicesException;
import edu.eci.cvds.utils.DatabaseStatus;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.checkerframework.checker.units.qual.A;
import org.primefaces.model.chart.PieChartModel;

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
    private int allOfferneed = 0;
    private String name;
    private String description;
    private String state;
    private String dateCreate;
    private String dateModification;
    private String userRole;
    private List<String> statusList;
    private List<Category> allCategories;
    private List<Category> reportCategories;
    private Category categoryToEdit;

    private PieChartModel pieModel1;
    private PieChartModel pieModel2;

    @PostConstruct
    public void init(){
        System.out.println("edu.eci.cvds.managedbeans.CategoryBean.init()");
        // TODO -> crear una funcion que genere los servicios, como en OfferBean
        categoryServices = getInjector().getInstance(CategoryServices.class);
        statusList = new ArrayList<>();
        try {
            reportCategories = categoryServices.getReportCategory();
        } catch (ServicesException e) {
            e.printStackTrace();
        }
        createPieModel();

        getUserInformation();
        for(Category utl: reportCategories){
            allOfferneed+= utl.getOffer() + utl.getNeed();
        }


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
                this.dateCreate = dateFormat.format(this.categoryToEdit.getDate_Create());
                this.dateModification = dateFormat.format(this.categoryToEdit.getDate_Modification());
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

    private void createPieModel(){
        System.out.println("edu.eci.cvds.managedbeans.CategoryBean.createPieModel()");

        pieModel1 = new PieChartModel();
        pieModel2 = new PieChartModel();
        for(Category offer: reportCategories){
            pieModel1.set(offer.getName(), offer.getOffer());
        }
        pieModel1.setTitle("");
        for(Category need: reportCategories){
            pieModel2.set(need.getName(), need.getNeed());
        }
        pieModel2.setTitle("");

        pieModel1.setShowDataLabels(true);
        pieModel1.setDataLabelFormatString("%dK");
        pieModel1.setLegendPosition("e");
        pieModel1.setShowDatatip(true);
        pieModel1.setShowDataLabels(true);
        pieModel1.setDataFormat("value");
        pieModel1.setDataLabelFormatString("%d");
        //pieModel1.setSeriesColors("00FF64, ff8c00, 87cefa, B477DE");

        pieModel2.setShowDataLabels(true);
        pieModel2.setDataLabelFormatString("%dK");
        pieModel2.setLegendPosition("e");
        pieModel2.setShowDatatip(true);
        pieModel2.setShowDataLabels(true);
        pieModel2.setDataFormat("value");
        pieModel2.setDataLabelFormatString("%d");
        //pieModel2.setSeriesColors("00FF64, ff8c00, 87cefa, B477DE");

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

    public List<Category> getReportCategories() {
        return reportCategories;
    }

    public void setReportCategories(List<Category> reportCategories) {
        this.reportCategories = reportCategories;
    }

    public PieChartModel getPieModel1() {
        return pieModel1;
    }

    public void setPieModel1(PieChartModel pieModel1) {
        this.pieModel1 = pieModel1;
    }

    public PieChartModel getPieModel2() {
        return pieModel2;
    }

    public void setPieModel2(PieChartModel pieModel2) {
        this.pieModel2 = pieModel2;
    }

    public int getAllOfferneed() {
        return allOfferneed;
    }

    public void setAllOfferneed(int allOfferneed) {
        this.allOfferneed = allOfferneed;
    }
}

