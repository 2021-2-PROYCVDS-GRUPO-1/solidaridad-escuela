package edu.eci.cvds.managedbeans;


import edu.eci.cvds.entities.Category;
import edu.eci.cvds.entities.Offer;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.services.CategoryServices;
import edu.eci.cvds.services.OfferServices;
import edu.eci.cvds.services.ServicesException;
import edu.eci.cvds.services.UserServices;
import edu.eci.cvds.utils.DatabaseStatus;
import edu.eci.cvds.utils.OfferStatus;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.primefaces.model.chart.*;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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

    @Inject
    private  CategoryServices categoryServices;

//    @Inject
//    private UserServices userServices;
//
//    private User usuario;


    private int userId;
    private int offerId;
    private int offerCategory;

    private String name;
    private String status;
    private String userRole;
    private String dateCreate;
    private String description;
    private String categoryName;
    private String dateModification;

    private Offer offerToEdit;

    private List<Offer> allOffers;
    private List<Offer> offerByUser;
    private List<String> statusList;
    private Collection<String> catTest;
    private HashMap<String, Integer> categories;

    private PieChartModel pieModel;

    @PostConstruct
    public void init(){
        System.out.println("edu.eci.cvds.managedbeans.OfferBean.init()");

        this.verifyValidUpdate();

        this.resetFields();

        generateServices();
        getUserInformation();
        generateList();

        statusList = new ArrayList<>();
        categories = new HashMap<String, Integer>();

        pieModel = createPieModel();

        try{
            for(OfferStatus status : OfferStatus.values()){
                System.out.println(status.getName());
                statusList.add(status.getName());
            }

        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void generateServices(){
        System.out.println("edu.eci.cvds.managedbeans.OfferBean.generateServices()");

        offerServices = getInjector().getInstance(OfferServices.class);
        categoryServices = getInjector().getInstance(CategoryServices.class);
//        userServices = getInjector().getInstance(UserServices.class);
    }

    public void generateList(){
        System.out.println("edu.eci.cvds.managedbeans.OfferBean.generateList()");

        try {
            this.categories = categoryServices.getCategories();
        } catch (ServicesException e) {
            e.printStackTrace();
        }
        catTest = categories.keySet();

        this.offerByUser = offerServices.getByUserID(userId);

        this.allOffers = offerServices.testGetAllOffers();
    }

    private void getUserInformation(){
        System.out.println("edu.eci.cvds.managedbeans.OfferBean.getUserInformation()");

        Subject subject = SecurityUtils.getSubject();
        this.userId = (int) subject.getSession().getAttribute("userId");
        this.userRole = (String) subject.getSession().getAttribute("role");
    }

    private PieChartModel createPieModel(){
        System.out.println("edu.eci.cvds.managedbeans.OfferBean.createPieModel()");

        pieModel = new PieChartModel();
        pieModel.set("Active", offerServices.countByStatus("ACTIVE"));
        pieModel.set("In Process", offerServices.countByStatus("IN PROCESS"));
        pieModel.set("Solved", offerServices.countByStatus("SOLVED"));
        pieModel.set("Closed", offerServices.countByStatus("CLOSED"));
        pieModel.setTitle("");
        pieModel.setShowDataLabels(true);
        pieModel.setDataLabelFormatString("%dK");
        pieModel.setLegendPosition("e");
        pieModel.setShowDatatip(true);
        pieModel.setShowDataLabels(true);
        pieModel.setDataFormat("value");
        pieModel.setDataLabelFormatString("%d");
        pieModel.setSeriesColors("00FF64, ff8c00, 87cefa, B477DE");
        return pieModel;

    }

    private String categoryName(int id){
        System.out.println("edu.eci.cvds.managedbeans.OfferBean.categoryName()");

        for(Map.Entry<String, Integer> entry : categories.entrySet()){
            if(id == entry.getValue()){
                return entry.getKey();
            }
        }
        return "";
    }


    public void createOffer(){
        System.out.println("edu.eci.cvds.managedbeans.OfferBean.createOffer()");

        getUserInformation();
        generateList();

        try{
            offerServices.createOffer(categories.get(categoryName), name, description, userId);
            this.resetFields();
            FacesContext.getCurrentInstance().getExternalContext().redirect("/offerList.xhtml");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void changeStatus(){
        System.out.println("edu.eci.cvds.managedbeans.OfferBean.changeStatus()");

        generateList();

        try{
            offerServices.changeStatus(name, status);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/offerList.xhtml");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteOffer(Offer offerToDelete) {
        System.out.println("edu.eci.cvds.managedbeans.OfferBean.deleteOffer()");

        try{
            offerServices.deleteOffer(offerToDelete.getOfferId());
            FacesContext.getCurrentInstance().getExternalContext().redirect("/offerList.xhtml");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void getOfferList(){
        System.out.println("edu.eci.cvds.managedbeans.OfferBean.getOfferList()");

        try {
            this.allOffers = offerServices.getAllOffers();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void goToUpdateOffer(Offer offer) {
        System.out.println("edu.eci.cvds.managedbeans.OfferBean.goToUpdateOffer()");

        this.offerToEdit = offer;

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/updateOffer.xhtml");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void verifyValidUpdate(){
        System.out.println("edu.eci.cvds.managedbeans.OfferBean.verifyValidUpdate()");

        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-M-dd");

            // TODO -> traer el nombre de la categoría
            // TODO -> Tengo acceso al ID pero no al nombre, ¿cómo lo traigo?

            if (this.offerToEdit.getOfferId() >= 0){
                this.offerId = this.offerToEdit.getOfferId();
                this.name = this.offerToEdit.getName();
                this.status = this.offerToEdit.getStatus();
                this.description = this.offerToEdit.getDescription();
                this.categoryName = categoryName(this.offerToEdit.getOfferCategory());
                this.dateCreate = dateFormat.format(this.offerToEdit.getDateCreation());
                this.dateModification = dateFormat.format(this.offerToEdit.getDateModification());
            }

            this.offerToEdit = null;

            this.resetFields();
        } catch (Exception e){
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/offerList.xhtml");
            } catch (Exception ex){
                ex.printStackTrace();
            }

        }
    }

    public void verifyIfUserHasAccess() {
        System.out.println("edu.eci.cvds.managedbeans.OfferBean.verifyIfUserHasAccess()");

        if (!this.userRole.equals("ADMIN")){
            return;
        }

        /*try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/mainMenu.xhtml");
        } catch (Exception ex){
            ex.printStackTrace();
        }*/
    }

    public void resetFields(){
        System.out.println("edu.eci.cvds.managedbeans.OfferBean.resetFields()");

        this.categoryName = "";
        this.name = "";
        this.description = "";
        this.status = "";
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<String> statusList) {
        this.statusList = statusList;
    }

    public Collection<String> getOfferListTest() {
        return catTest;
    }

    public void setOfferListTest(List<String> offerListTest) {
        this.catTest = offerListTest;
    }

    public CategoryServices getCategoryServices() {
        return categoryServices;
    }

    public void setCategoryServices(CategoryServices categoryServices) {
        this.categoryServices = categoryServices;
    }

    public Collection<String> getCatTest() {
        return catTest;
    }

    public void setCatTest(List<String> catTest) {
        this.catTest = catTest;
    }

    public String getCategoryName() { return categoryName; }

    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    public HashMap<String, Integer> getCategories() { return categories; }

    public void setCategories(HashMap<String, Integer> categories) { this.categories = categories; }

    public void setCatTest(Collection<String> catTest) { this.catTest = catTest; }

    public List<Offer> getOfferByUser() {
        return offerByUser;
    }

    public void setOfferByUser(List<Offer> offerByUser) {
        this.offerByUser = offerByUser;
    }

    public PieChartModel getPieModel() {
        return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public List<Offer> getAllOffers() {
        return allOffers;
    }

    public void setAllOffers(List<Offer> allOffers) {
        this.allOffers = allOffers;
    }

    public Offer getOfferToEdit() {
        return offerToEdit;
    }

    public void setOfferToEdit(Offer offerToEdit) {
        this.offerToEdit = offerToEdit;
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


}
