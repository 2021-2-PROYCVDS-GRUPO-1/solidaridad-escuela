package edu.eci.cvds.managedbeans;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import edu.eci.cvds.entities.User;
import edu.eci.cvds.security.Login;
import edu.eci.cvds.services.CategoryServices;
import edu.eci.cvds.services.OfferServices;
import edu.eci.cvds.services.UserServices;
import edu.eci.cvds.utils.OfferStatus;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import com.google.inject.Inject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Laura Valentina García León
 * @author Laura Nathalia García
 * @author Juan Sebastián Cadavid
 * @author Juan David Murillo
 * @version 17/10/2021
 */

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean extends BasePageBean {
    @Inject
    private Login login;

    @Inject
    private UserServices userServices;

    private String email;
    private String password;

    @PostConstruct
    public void init(){
        System.out.println("edu.eci.cvds.managedbeans.LoginBean.init()");

        userServices = getInjector().getInstance(UserServices.class);
        login = getInjector().getInstance(Login.class);
    }

    /**
     * Metodo que realiza el login del usuario
     * FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"log","Usuario desconocido."));
     */
    public void signIn(){
        System.out.println("edu.eci.cvds.managedbeans.LoginBean.signIn()");

        try{
            //currentUser = SecurityUtils.getSubject();
            if (this.login.isLoggedIn()) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/mainMenu.xhtml");
                }
                else {
                    this.login.signIn(email,password, false);

                    User user = userServices.getUserByEmail(email);
                    Subject subject = SecurityUtils.getSubject();
                    subject.getSession().setAttribute("userId", user.getUserId());
                    subject.getSession().setAttribute("role", user.getRole());

                    FacesContext.getCurrentInstance().getExternalContext().redirect("/mainMenu.xhtml");
                }
            }

        catch( Exception exception){
            exception.printStackTrace();
        }
    }

    /**
     * Metodo que cierra la sesion del usuario actual
     */
    public void signOut(){
        System.out.println("edu.eci.cvds.managedbeans.LoginBean.signOut()");

        try{
            this.login.signOut();
        }
        catch(Exception exception){
            exception.printStackTrace();
        }
    }

    /**
     *  Si el usuario no está autenticado, devuelve al login
     */
    public void verifyIfUserIsAuthenticated() {
        System.out.println("edu.eci.cvds.managedbeans.LoginBean.verifyIfUserIsAuthenticated()");

        if ( SecurityUtils.getSubject().isAuthenticated()){
            return;
        }

        try{
            FacesContext.getCurrentInstance().getExternalContext().redirect("/login.xhtml");
        }catch(Exception e){
            e.printStackTrace();
        }
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
}
