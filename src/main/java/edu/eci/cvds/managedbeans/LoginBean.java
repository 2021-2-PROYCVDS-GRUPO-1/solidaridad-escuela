package edu.eci.cvds.managedbeans;

import com.google.inject.Inject;
import edu.eci.cvds.security.Login;
import edu.eci.cvds.services.ServicesException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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

            if (login.isLoggedIn()){
                System.out.println("--- USUARIO YA ESTÁ LOGGEADO");
            } else {
                login.signIn(email, password, rememberMe);
            }
        } catch (ServicesException e) {
            message = e.getMessage();
            status = FacesMessage.SEVERITY_WARN;
        }
    }

}
