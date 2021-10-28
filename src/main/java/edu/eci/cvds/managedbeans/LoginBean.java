package edu.eci.cvds.managedbeans;

import com.google.inject.Inject;
import edu.eci.cvds.security.Login;
import edu.eci.cvds.services.ServicesException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * @author Laura Valentina García León
 * @author Laura Nathalia García
 * @author Juan Sebastián Cadavid
 * @author Juan David Murillo
 * @version 17/10/2021
 */

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean extends BasePageBean{
    @Inject
    private Login login;

    private String email;
    private String password;
    private boolean rememberMe;
    private Subject currentUser;
    private String message;
    private FacesMessage.Severity status;

    public void signIn() {
        try {
            // Take the current user
            this.currentUser = SecurityUtils.getSubject();

            if (this.login.isLoggedIn()){
                System.out.println("--- USUARIO YA ESTÁ LOGGEADO");
            } else {
                this.login.signIn(email, password, rememberMe);

                // $
                FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "index.xhtml");
            }
        } catch (ServicesException e) {
            message = e.getMessage();
            status = FacesMessage.SEVERITY_WARN;
        }
    }

    public void signOut() {
        try {
            this.login.logout();
        } catch (ServicesException e) {
            e.printStackTrace();
        }
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
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

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public Subject getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Subject currentUser) {
        this.currentUser = currentUser;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public FacesMessage.Severity getStatus() {
        return status;
    }

    public void setStatus(FacesMessage.Severity status) {
        this.status = status;
    }
}
