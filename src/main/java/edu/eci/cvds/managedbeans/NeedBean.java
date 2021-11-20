package edu.eci.cvds.managedbeans;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Category;
import edu.eci.cvds.entities.Need;
import edu.eci.cvds.services.*;
import edu.eci.cvds.utils.DatabaseStatus;
import edu.eci.cvds.utils.OfferStatus;
import edu.eci.cvds.utils.Urgency;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;


import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
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
    private String name;
    private String description;
    private String categoryName;
    private String urgency;
    private Date creationDate;
    private String status;
    private Date modificationDate;
    private int createdByUser;
    private int userId;

    private List<String> statusList;
    private List<Category> categoryList;
    private List<String> urgencyList;

    private HashMap<String, Integer> categories;
    private Collection<String> catTest;

    @PostConstruct
    public void init(){
        System.out.println("edu.eci.cvds.managedbeans.NeedBean.init()");

        statusList = new ArrayList<>();
        categoryList = new ArrayList<>();
        urgencyList = new ArrayList<>();

        categories = new HashMap<String, Integer>();

        this.generateServices();
        this.getUserInformation();
        this.generateList();

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

    public void generateList(){
        System.out.println("edu.eci.cvds.managedbeans.NeedBean.generateList()");

        categories = categoryServices.getCategories();
        catTest = categories.keySet();

        //this.offerByUser = offerServices.OfferbyUserId(userId);
    }

    public void registerNeed(){
        System.out.println("edu.eci.cvds.managedbeans.NeedBean.registerNeed()");

        // TODO -> Traer el id del usuario que necesito
        int testUser = 0;

        try{
            System.out.println("Anadiendo necesidad con con nombre: " + this.name
                    + "\nDescripcion: " + this.description
                    + "\nEstado: " + this.status
                    + "\nCategoría: " + this.category
                    + "\nUrgencia: " + this.urgency
                    + "\nPor el usuario: " + testUser
                    );

            needServices.registerNeed(categories.get(categoryName),
                    this.name,
                    this.description,
                    this.urgency,
                    this.status,
                    this.userId
                    );
        }catch(Exception e){
            e.printStackTrace();
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
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
}
