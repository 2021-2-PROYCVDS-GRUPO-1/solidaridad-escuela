package edu.eci.cvds.security;

import edu.eci.cvds.services.HistorialEquiposException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 28/10/2020
 */
public class ShiroLogger implements Log {

    @Override
    public void login(String correo, String constraseña, boolean recordarme) throws HistorialEquiposException {
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(correo, new Sha256Hash(constraseña).toHex(), recordarme);
            subject.getSession().setAttribute("correo", correo);
            subject.login(token);
        }
        catch (LockedAccountException lockedAccountException){
            throw new HistorialEquiposException("Demasiados intentos.",lockedAccountException);
        }
        catch (UnknownAccountException unknownAccountException){
            throw new HistorialEquiposException("Credenciales incorrectas.",unknownAccountException);
        }
        catch (IncorrectCredentialsException incorrectCredentialsException ){
            throw new HistorialEquiposException("Credenciales incorrectas.",incorrectCredentialsException);
        }
        catch (AuthenticationException authenticationException){
            throw new HistorialEquiposException("Error al autenticar.",authenticationException);
        }
        catch( Exception exception){
            throw new HistorialEquiposException("Ocurrio un error inesperado",exception);
        }
    }

    @Override
    public void logout()throws HistorialEquiposException {
        SecurityUtils.getSubject().logout();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/index2.html");
        } catch (IOException ioException) {
            ioException.printStackTrace();
            throw new HistorialEquiposException("Ocurrio un error al encontrar la pagina",ioException);
        }
    }

    @Override
    public boolean isLogged() {
        return SecurityUtils.getSubject().isAuthenticated();
    }
}
