package edu.eci.cvds.entities;

/**
 * @author Laura Valentina García León
 * @author Laura Nathalia García
 * @author Juan Sebastián Cadavid
 * @author Juan David Murillo
 * @version 17/10/2021
 */
public class User {
    // TODO: Pasar el rol y el estado a los utils

    private int userId;
    private int databaseId;
    private String status;
    private String firstName;
    private String lastname;
    private String email;
    private String username;
    private String password;
    private String role;
    private int maxNeeds;



    public User() {
    }

    public User(int userId, int databaseId, String status, String firstName, String lastname, String email, String username, String password, String role, int maxNeeds) {
        this.userId = userId;
        this.databaseId = databaseId;
        this.status = status;
        this.firstName = firstName;
        this.lastname = lastname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
        this.maxNeeds = maxNeeds;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getDatabaseId() {
        return databaseId;
    }

    public void setDatabaseId(int databaseId) {
        this.databaseId = databaseId;
    }

    public int getMaxNeeds() {
        return maxNeeds;
    }

    public void setMaxNeeds(int maxNeeds) {
        this.maxNeeds = maxNeeds;
    }
}
