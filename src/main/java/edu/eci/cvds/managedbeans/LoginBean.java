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


@SuppressWarnings("deprecation")
// TODO -> change name to login bean
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean extends BasePageBean {
    @Inject
    private Login login;

    @Inject
    private UserServices userServices;


    private String email;
    private String password;
    private boolean rememberMe;
    private Subject currentUser;
    private String message;
    private FacesMessage.Severity status;


    @PostConstruct
    public void init(){
        System.out.println("edu.eci.cvds.managedbeans.LoginBean.init()");

        userServices = getInjector().getInstance(UserServices.class);
        login = getInjector().getInstance(Login.class);
    }


    // TODO -> verify everything
    /**
     * Metodo que realiza el login del usuario
     * FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"log","Usuario desconocido."));
     */
    public void signIn(){
        System.out.println("edu.eci.cvds.managedbeans.LoginBean.signIn()");

        try{
            sinErrores();
            currentUser = SecurityUtils.getSubject();
//            if (this.login.isLoggedIn()) {
            if (false) {

                    System.out.println("Ya esta loggeado----------------------------");
                    //throw new HistorialEquiposException("Ya estas loggeado");//solo atrapar los errores.
                }
                else {
                    System.out.println(email + "-" +password);
                    System.out.println(email + "-" +new Sha256Hash(password).toHex());
                    this.login.signIn(email,password, false);
                    //redireccionar();
                    User user = userServices.getUserByEmail(email);
                    Subject subject = SecurityUtils.getSubject();
                    subject.getSession().setAttribute("userId", user.getUserId());
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/mainMenu.xhtml");
                }
            }

        catch( Exception exception){
            exception.printStackTrace();
            message = exception.getMessage();
            status = FacesMessage.SEVERITY_WARN;
            restablecer();
        }
    }

    /**
     * metodo que establece los mensajes a mostrar en caso que no exista un error
     */
    public void sinErrores(){
        message ="Login exitoso";
        status = FacesMessage.SEVERITY_INFO;
    }

    /**
     * Metodo que redirecciona al usuario a una pagina, dependiendo de su rol
     */
    public void redireccionar() {
        System.out.println("edu.eci.cvds.managedbeans.LoginBean.redireccionar()");

        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            if (esAdmin()) {
                HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
                session.setAttribute("email", email);
                facesContext.getExternalContext().redirect("../admin/admin.xhtml");
            }
            else if (esUsuario()) {
                HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
                session.setAttribute("email", email);
                facesContext.getExternalContext().redirect("../usuario/usuario.xhtml");
            }
        }
        catch (Exception exception) {
            signOut();
        }
    }

    /**
     * Metodo que cierra la sesion del usuario actual
     */
    public void signOut(){
        System.out.println("edu.eci.cvds.managedbeans.LoginBean.signOut()");

        try{
            this.login.signOut();
            restablecer();
        }
        catch(Exception exception){
        }
    }

    /**
     *  Si el usuario no está autenticado, devuelve al login
     */
    public void verifyIfUserIsAuthenticated() {
        System.out.println("edu.eci.cvds.managedbeans.LoginBean.verifyIfUserIsAuthenticated()");

        System.out.println("   ");
        System.out.println("   ");
        //System.out.println(SecurityUtils.getSubject().isAuthenticated());

        if ( SecurityUtils.getSubject().isAuthenticated()){
            System.out.println("   ");
            System.out.println("   ");
            System.out.println(((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRequestURI());
            System.out.println("   ");
            System.out.println("   ");


            return;
        }

        try{
            FacesContext.getCurrentInstance().getExternalContext().redirect("/login.xhtml");
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    /**
     * Funcion que retorna si el rol del usuario actual es Admin
     * @return boolean, que dice si el rol del usuario actual es Admin
     */
    public boolean esAdmin() {
        return currentUser.hasRole("administrador");
    }

    /**
     * Funcion que retorna si el rol del usuario actual es Usuario
     * @return  boolean, que dice si el rol del usuario actual es Usuario
     */
    public boolean esUsuario() {
        return currentUser.hasRole("usuario");
    }

    /**
     * Metodo que retorna el email que el usuario ingreso
     * @return String, cadena que representa el email del usuario
     */
    public String getemail() {
        return email;
    }

    /**
     * Metodo que establece el email del usuario
     * @param email, String que representa el email a establecer
     */
    public void setemail(String email) {
        this.email = email;
    }

    /**
     * Metodo que establece la password del usuario
     * @param password, String que representa la password del usuario
     */
    public void setpassword(String password) {
        this.password = password;
    }

    /**
     * Metodo que retorna la password del usuario
     * @return String, cadena que representa la password del usuario
     */
    public String getpassword() {
        return password;
    }

    /**
     * metodo que restablece los valores de los input
     */
    public void restablecer(){
        password = "";
        email = "";
    }

    /**
     * Metodo que muestra en un mensaje del status del log in
     */
    public void statusLogin() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(status, "LogIn", message));
    }


}
