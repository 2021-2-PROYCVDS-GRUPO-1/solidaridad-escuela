package edu.eci.cvds.managedbeans;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Category;
import edu.eci.cvds.entities.Need;
import edu.eci.cvds.services.*;
import edu.eci.cvds.utils.OfferStatus;
import edu.eci.cvds.utils.Urgency;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.primefaces.model.chart.*;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@ManagedBean(name = "needBean")
@ApplicationScoped
public class NeedBean extends BasePageBean{
    @Inject
    private NeedServices needServices;

    @Inject
    private  CategoryServices categoryServices;

    private int id;
    private int category;
    private int createdByUser;
    private int userId;
    private String name;
    private String description;
    private String categoryName;
    private String urgency;
    private String creationDate;
    private String status;
    private String modificationDate;
    private Need needToEdit;
    private List<String> statusList;
    private List<String> urgencyList;
    private List<Category> categoryList;
    private List<Need> allNeeds;
    private Collection<String> catTest;
    private HashMap<String, Integer> categories;
    private PieChartModel pieModel;


    @PostConstruct
    public void init(){
        System.out.println("edu.eci.cvds.managedbeans.NeedBean.init()");

        categories = new HashMap<String, Integer>();

        this.generateServices();
        this.getUserInformation();
        this.generateList();

        statusList = new ArrayList<>();
        categoryList = new ArrayList<>();
        urgencyList = new ArrayList<>();



        pieModel = createPieModel();



        try{
            // Status
            for(OfferStatus status : OfferStatus.values()){
                statusList.add(status.getName());
            }

            // Urgency
            for(Urgency myUrgency : Urgency.values()){
                urgencyList.add(myUrgency.toString());
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void generateServices(){
        System.out.println("edu.eci.cvds.managedbeans.NeedBean.generateServices()");

        needServices = getInjector().getInstance(NeedServices.class);
        categoryServices = getInjector().getInstance(CategoryServices.class);
    }

    private void getUserInformation(){
        System.out.println("edu.eci.cvds.managedbeans.NeedBean.userInformation()");

        Subject subject = SecurityUtils.getSubject();
        this.userId = (int) subject.getSession().getAttribute("userId");
    }

    public void generateList() {
        System.out.println("edu.eci.cvds.managedbeans.NeedBean.generateList()");

        try {
            categories = categoryServices.getCategories();
        } catch (ServicesException e) {
            e.printStackTrace();
        }
        catTest = categories.keySet();

        this.allNeeds = needServices.testGetAllOffers();
        System.out.println(allNeeds);
        //this.offerByUser = offerServices.OfferbyUserId(userId);
    }

    private PieChartModel createPieModel(){
        System.out.println("edu.eci.cvds.managedbeans.OfferBean.createPieModel()");

        pieModel = new PieChartModel();
        pieModel.set("Active", needServices.countByStatus("ACTIVE"));
        pieModel.set("In Process", needServices.countByStatus("IN PROCESS"));
        pieModel.set("Solved", needServices.countByStatus("SOLVED"));
        pieModel.set("Closed", needServices.countByStatus("CLOSED"));
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

    public void registerNeed(){
        System.out.println("edu.eci.cvds.managedbeans.NeedBean.registerNeed()");

        try{
            System.out.println("Anadiendo necesidad con con nombre: " + this.name
                    + "\nDescripcion: " + this.description
                    + "\nEstado: " + this.status
                    + "\nCategoría: " + this.category
                    + "\nUrgencia: " + this.urgency
                    + "\nPor el usuario: " + this.userId
                    );

            System.out.println("--- NEED SERVICES ---");
            System.out.println(needServices);

            System.out.println("--- CATEGORIES ---");
            System.out.println(categories.keySet().toString());

            System.out.println("--- CATEGORY NAME ---");
            System.out.println(categoryName);

            System.out.println("--- CATEGORY GET NAME ---");
            System.out.println(categories.get(categoryName));

            needServices.registerNeed(categories.get(categoryName),
                    this.name,
                    this.description,
                    this.urgency,
                    this.status,
                    this.userId
                    );

            try{
                FacesContext.getCurrentInstance().getExternalContext().redirect("/needList.xhtml");
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void updateNeedStatus(){
        System.out.println("edu.eci.cvds.managedbeans.NeedBean.updateNeedStatus()");

        generateList();

        try{
            needServices.updateStatus(id, status);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/needList.xhtml");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteNeed(Need needToDelete) {
        System.out.println("edu.eci.cvds.managedbeans.NeedBean.deleteNeed()");

        try{
            needServices.deleteNeed(needToDelete.getId());
            FacesContext.getCurrentInstance().getExternalContext().redirect("/needList.xhtml");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void getNeedList(){
        System.out.println("edu.eci.cvds.managedbeans.NeedBean.getNeedList()");

        try {
            this.allNeeds = needServices.getAllNeeds();

            for(Need need : this.allNeeds){
                System.out.println(need.getName());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void goToUpdateNeed(Need need) {
        System.out.println("edu.eci.cvds.managedbeans.NeedBean.goToUpdateNeed()");

        this.needToEdit = need;

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/updateNeed.xhtml");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void verifyValidUpdate(){
        System.out.println("edu.eci.cvds.managedbeans.NeedBean.verifyValidUpdate()");

        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-M-dd");

            // TODO -> traer el nombre de la categoría
            // TODO -> Tengo acceso al ID pero no al nombre, ¿cómo lo traigo?

            if (this.needToEdit.getId() >= 0){
                this.id = this.needToEdit.getId();
                // TODO -> plis nombre de la categoría
                this.categoryName = "LAU CAMBIAME";
                this.name = this.needToEdit.getName();
                this.description = this.needToEdit.getDescription();
                this.urgency = this.needToEdit.getUrgency();
                this.creationDate = dateFormat.format(this.needToEdit.getCreationDate());
                this.status = this.needToEdit.getStatus();
                this.modificationDate = dateFormat.format(this.needToEdit.getModificationDate());
                this.createdByUser = this.needToEdit.getCreatedByUser();
            }

            this.needToEdit = null;
        } catch (Exception e){
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/needList.xhtml");
            } catch (Exception ex){
                ex.printStackTrace();
            }

        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
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

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(int createdByUser) {
        this.createdByUser = createdByUser;
    }

    public List<String> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<String> statusList) {
        this.statusList = statusList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<String> getUrgencyList() {
        return urgencyList;
    }

    public void setUrgencyList(List<String> urgencyList) {
        this.urgencyList = urgencyList;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public HashMap<String, Integer> getCategories() {
        return categories;
    }

    public void setCategories(HashMap<String, Integer> categories) {
        this.categories = categories;
    }

    public Collection<String> getCatTest() {
        return catTest;
    }

    public void setCatTest(Collection<String> catTest) {
        this.catTest = catTest;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }

    public List<Need> getAllNeeds() {
        return allNeeds;
    }

    public void setAllNeeds(List<Need> allNeeds) {
        this.allNeeds = allNeeds;
    }

    public Need getNeedToEdit() {
        return needToEdit;
    }

    public void setNeedToEdit(Need needToEdit) {
        this.needToEdit = needToEdit;
    }

    public NeedServices getNeedServices() {
        return needServices;
    }

    public void setNeedServices(NeedServices needServices) {
        this.needServices = needServices;
    }

    public CategoryServices getCategoryServices() {
        return categoryServices;
    }

    public void setCategoryServices(CategoryServices categoryServices) {
        this.categoryServices = categoryServices;
    }

    public PieChartModel getPieModel() {
        return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }
}
