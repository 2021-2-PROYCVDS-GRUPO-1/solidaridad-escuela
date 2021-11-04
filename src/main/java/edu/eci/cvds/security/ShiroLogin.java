package edu.eci.cvds.security;

import edu.eci.cvds.services.ServicesException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 * @author Laura Valentina García León
 * @author Laura Nathalia García
 * @author Juan Sebastián Cadavid
 * @author Juan David Murillo
 * @version 17/10/2021
 */
public class ShiroLogin implements Login {

    @Override
    public void signIn(String email, String password, boolean rememberMe) throws ServicesException {
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(email, new Sha256Hash(password).toHex(), rememberMe);
            subject.getSession().setAttribute("email", email);
            subject.login(token);
        }
        catch (LockedAccountException lockedAccountException){
            throw new ServicesException("Demasiados intentos.",lockedAccountException);
        }
        catch (UnknownAccountException unknownAccountException){
            throw new ServicesException("Credenciales incorrectas.",unknownAccountException);
        }
        catch (IncorrectCredentialsException incorrectCredentialsException ){
            throw new ServicesException("Credenciales incorrectas.",incorrectCredentialsException);
        }
        catch (AuthenticationException authenticationException){
            throw new ServicesException("Error al autenticar.",authenticationException);
        }
        catch( Exception exception){
            throw new ServicesException("Ocurrio un error inesperado",exception);
        }
    }

    @Override
    public void logout()throws ServicesException {
        SecurityUtils.getSubject().logout();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/index.xhtml");
        } catch (IOException ioException) {
            ioException.printStackTrace();
            throw new ServicesException("Ocurrio un error al encontrar la pagina",ioException);
        }
    }

    @Override
    public boolean isLoggedIn() {
        return SecurityUtils.getSubject().isAuthenticated();
    }
}
