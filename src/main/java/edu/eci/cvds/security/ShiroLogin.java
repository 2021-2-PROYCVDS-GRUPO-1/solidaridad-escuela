package edu.eci.cvds.security;

import edu.eci.cvds.services.ServicesException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;

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
        } catch (LockedAccountException lockedAccountException){
            throw new ServicesException("Ha superado el máximo de intentos permitidos", lockedAccountException);
        }
        catch (UnknownAccountException unknownAccountException){
            throw new ServicesException("El email o la contraseña no son válidos", unknownAccountException);
        }
        catch (IncorrectCredentialsException incorrectCredentialsException ){
            throw new ServicesException("El email o la contraseña no son válidos", incorrectCredentialsException);
        }
        catch (AuthenticationException authenticationException){
            throw new ServicesException("Hubo un fallo de autenticación", authenticationException);
        }
        catch( Exception exception){
            throw new ServicesException("Ocurrió un error inesperado", exception);
        }
    }

    @Override
    public void signUp() throws ServicesException {

    }

    @Override
    public void logout() throws ServicesException {

    }

    @Override
    public boolean isLoggedIn() {
        return false;
    }
}
