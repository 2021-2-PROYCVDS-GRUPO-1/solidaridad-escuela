package edu.eci.cvds.managedbeans;

import edu.eci.cvds.services.CategoryServices;
import edu.eci.cvds.services.UserServices;
import edu.eci.cvds.utils.DatabaseStatus;
import edu.eci.cvds.utils.Role;
import org.apache.shiro.crypto.hash.Sha256Hash;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "userBean")
@ApplicationScoped
public class UserBean extends BasePageBean{
    @Inject
    private UserServices userServices;

    private int userId;
    private int databaseId;
    // $
    private String status;
    // private DatabaseStatus status;
    private String firstName;
    private String lastname;
    private String email;
    private String username;
    private String password;
    // $
    private String role;
    //private Role role;
    private int maxNeeds;

    private List<String> statusList;
    private List<String> userRoleList;

    @PostConstruct
    public void init(){
        statusList = new ArrayList<>();
        userRoleList = new ArrayList<>();

        userServices = getInjector().getInstance(UserServices.class);

        try{
            for(DatabaseStatus status : DatabaseStatus.values()){
                System.out.println(status.toString());
                statusList.add(status.toString());
            }

            for (Role role: Role.values()){
                System.out.println(role.getName());
                userRoleList.add(role.getName());
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    public void createUser() {
        // this.status = DatabaseStatus.ENABLED;
        //this.status = "ENABLED";
        // this.role = Role.STUDENT;
        //this.role = "STUDENT";

        System.out.println("User ID: "+ this.userId +
                "\nStatus: " + this.status +
                "\nFirst Name: " + this.firstName +
                "\nLastname: " + this.lastname +
                "\nEmail: " + this.lastname +
                "\nUsername: " + this.username +
                "\nPassword: " + this.password +
                "\nRole: " + this.role +
                "\nMax needs: " + this.maxNeeds);
        try{
            userServices.registerUser(this.userId,this.status
                    ,this.firstName,this.lastname,this.lastname,
                    this.username, new Sha256Hash(this.password).toHex(),this.role, this.maxNeeds);

        }catch(Exception e){
            e.printStackTrace();
            //System.out.println(e.getMessage());
        }
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDatabaseId() {
        return databaseId;
    }

    public void setDatabaseId(int databaseId) {
        this.databaseId = databaseId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getMaxNeeds() {
        return maxNeeds;
    }

    public void setMaxNeeds(int maxNeeds) {
        this.maxNeeds = maxNeeds;
    }

    public List<String> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<String> statusList) {
        this.statusList = statusList;
    }

    public List<String> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(List<String> userRoleList) {
        this.userRoleList = userRoleList;
    }
}

