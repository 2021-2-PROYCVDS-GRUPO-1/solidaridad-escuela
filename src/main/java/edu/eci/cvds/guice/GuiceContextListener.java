package edu.eci.cvds.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.eci.cvds.persistence.mybatis.MyBATISCategoryDAO;
import edu.eci.cvds.persistence.mybatis.MyBATISUserDAO;
import edu.eci.cvds.persistence.mybatis.dao.CategoryDAO;
import edu.eci.cvds.persistence.mybatis.MyBATISOfferDAO;
import edu.eci.cvds.persistence.mybatis.MyBATISUserDAO;
import edu.eci.cvds.persistence.mybatis.dao.OfferDAO;

import edu.eci.cvds.persistence.mybatis.dao.UserDAO;
import edu.eci.cvds.security.Login;
import edu.eci.cvds.security.ShiroLogin;
import edu.eci.cvds.services.OfferServices;
import edu.eci.cvds.services.Services;
import edu.eci.cvds.services.impl.OfferServicesImpl;
import edu.eci.cvds.services.impl.ServicesImpl;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Laura Valentina García León
 * @author Laura Nathalia García
 * @author Juan Sebastián Cadavid
 * @author Juan David Murillo
 * @version 17/10/2021
 */
public class GuiceContextListener implements ServletContextListener {
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.removeAttribute(Injector.class.getName());
    }

    public void contextInitialized(ServletContextEvent servletContextEvent){
        Injector injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setEnvironmentId("development");
                setClassPathResource("mybatis-config.xml");





                // DAO
                bind(Login.class).to(ShiroLogin.class);
                bind(UserDAO.class).to(MyBATISUserDAO.class);
                bind(CategoryDAO.class).to(MyBATISCategoryDAO.class);
                bind(OfferDAO.class).to(MyBATISOfferDAO.class);

                // SERVICES
                bind(Services.class).to(ServicesImpl.class);
                bind(OfferServices.class).to(OfferServicesImpl.class);
            }
        });

        servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
    }
}
