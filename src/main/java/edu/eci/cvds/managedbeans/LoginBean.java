package edu.eci.cvds.managedbeans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import edu.eci.cvds.security.Login;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import com.google.inject.Inject;
import javax.servlet.http.HttpSession;
import edu.eci.cvds.security.Log;

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

    private String email;
    private String password;
    private boolean rememberMe;
    private Subject currentUser;
    private String message;
    private FacesMessage.Severity status;

    // TODO -> verify everything
    /**
     * Metodo que realiza el login del usuario
     * FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"log","Usuario desconocido."));
     */
    public void signIn(){
        try{
            sinErrores();
            currentUser = SecurityUtils.getSubject();
            if (this.login.isLoggedIn()) {
                System.out.println("Ya esta loggeado----------------------------");
                //throw new HistorialEquiposException("Ya estas loggeado");//solo atrapar los errores.
            }
            else {
                this.login.signIn(email, password, false);
                //redireccionar();

                FacesContext.getCurrentInstance().getExternalContext().redirect("/index.xhtml");
            }
        }
        catch( Exception exception){
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
            logOut();
        }
    }

    /**
     * Metodo que cierra la sesion del usuario actual
     */
    public void logOut(){
        try{
            this.login.logout();
            restablecer();
        }
        catch(Exception exception){
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
