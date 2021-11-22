package edu.eci.cvds.security;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * se encarga de controlar que los usuarios solo puedan volver al login sii hicieron log-out
 * clase tomada de una respuesta en stackOverFlow
 * Referencia: https://stackoverflow.com/questions/55668274/with-shiro-ini-how-i-can-block-a-page-of-a-logged-users-only-not-logged-user
 */
public class OnlyNotAutenticated extends AccessControlFilter {
    String welcomeurl ="/index.html";

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        Subject subject = getSubject(request, response);
        return !subject.isAuthenticated(); // THE POINT

    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        Subject subject = getSubject(request, response);
        if( subject.hasRole("administrador")){
            welcomeurl = "admin/admin.xhtml";
        }
        else if( subject.hasRole("usuario") ){
            welcomeurl = "usuario/usuario.xhtml";
        }
        WebUtils.issueRedirect(request, response, welcomeurl);
        return false;//What to do if try to go to login -> go welcome page of auth users
    }

    public String getWelcomeurl() {
        return welcomeurl;
    }

    public void setWelcomeurl(String welcomeurl) {
        this.welcomeurl = welcomeurl;
    }
}