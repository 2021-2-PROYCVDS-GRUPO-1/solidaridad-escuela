package edu.eci.cvds.managedbeans;


import edu.eci.cvds.entities.Offer;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.services.CategoryServices;
import edu.eci.cvds.services.OfferServices;
import edu.eci.cvds.services.UserServices;
import edu.eci.cvds.utils.DatabaseStatus;
import edu.eci.cvds.utils.OfferStatus;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.primefaces.model.chart.*;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
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

    @Inject
    private UserServices userServices;

    private User usuario;
    //private int offerId;
    private int offerCategory;
    private String categoryName;
    private String name;
    private String description;
    private String status;
    private int userId;
    private List<String> statusList;
    private HashMap<String, Integer> categories;
    private Collection<String> catTest;
    private List<String> offerByUser;
    private PieChartModel pieModel;


    @PostConstruct
    public void init(){
        System.out.println("edu.eci.cvds.managedbeans.OfferBean.init()");

        statusList = new ArrayList<>();
        categories = new HashMap<String, Integer>();
        generateServices();
        getUserInformation();
        generateList();
        pieModel = createPieModel();
        System.out.println("-------PIE MODEL ------");
        System.out.println(pieModel);

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
        userServices = getInjector().getInstance(UserServices.class);
    }

    public void generateList(){
        System.out.println("edu.eci.cvds.managedbeans.OfferBean.generateList()");

        categories = categoryServices.getCategories();
        catTest = categories.keySet();

        this.offerByUser = offerServices.OfferbyUserId(userId);
    }

    private void getUserInformation(){
        System.out.println("edu.eci.cvds.managedbeans.OfferBean.getUserInformation()");

        Subject subject = SecurityUtils.getSubject();
        this.userId = (int) subject.getSession().getAttribute("userId");
    }

    private PieChartModel createPieModel(){
        System.out.println("edu.eci.cvds.managedbeans.OfferBean.createPieModel()");

        pieModel = new PieChartModel();
        System.out.println("---------COUNT----------");
        System.out.println("CUENTA " + "" + offerServices.countByStatus("ACTIVE"));
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

    public void createOffer(){
        System.out.println("edu.eci.cvds.managedbeans.OfferBean.createOffer()");

        getUserInformation();
        generateList();

        System.out.println(offerCategory + " " + name + " " + description + " " + userId );
        try{
            offerServices.createOffer(categories.get(categoryName), name, description, userId);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void changeStatus(){
        System.out.println("edu.eci.cvds.managedbeans.OfferBean.changeStatus()");

        generateList();
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

    public List<String> getOfferByUser() {
        return offerByUser;
    }

    public void setOfferByUser(List<String> offerByUser) {
        this.offerByUser = offerByUser;
    }

    public PieChartModel getPieModel() {
        return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }
}
