package edu.eci.cvds.guice;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import edu.eci.cvds.persistence.mybatis.*;
import edu.eci.cvds.persistence.mybatis.dao.*;
import edu.eci.cvds.security.Login;
import edu.eci.cvds.security.ShiroLogin;
import edu.eci.cvds.services.*;
import edu.eci.cvds.services.impl.*;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import com.google.inject.Guice;
import com.google.inject.Injector;

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

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Injector injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setEnvironmentId("development");
                setClassPathResource("mybatis-config.xml");

                bind(Login.class).to(ShiroLogin.class);
                
                // DAO
                bind(UserDAO.class).to(MyBATISUserDAO.class);
                bind(CategoryDAO.class).to(MyBATISCategoryDAO.class);
                bind(OfferDAO.class).to(MyBATISOfferDAO.class);
                // bind(NovedadDAO.class).to(MyBATISNovedadDAO.class);
                // bind(ElementoDAO.class).to(MyBATISElementoDAO.class);
                // bind(EquipoDAO.class).to(MyBATISEquipoDAO.class);
                // bind(UsuarioDAO.class).to(MyBATISUsuarioDAO.class);
                // bind(LaboratorioDAO.class).to(MYBATISLaboratorioDAO.class);

                // SERVICES
                bind(Services.class).to(ServicesImpl.class);
                bind(CategoryServices.class).to(CategoryServicesImpl.class);
                bind(OfferServices.class).to(OfferServicesImpl.class);
                // bind(HistorialServicios.class).to(HistorialServiciosImpl.class);
                // bind(ServiciosEquipo.class).to(ServiciosEquipoImpl.class);
                // bind(ServiciosElemento.class).to(ServiciosElementoImpl.class);
                // bind(ServiciosLaboratorio.class).to(ServiciosLaboratorioImpl.class);
                // bind(ServiciosNovedad.class).to(ServiciosNovedadImpl.class);
            }
        });

        servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
    }
}