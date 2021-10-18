package edu.eci.cvds.services;

import com.google.inject.Injector;
import edu.eci.cvds.persistence.mybatis.MyBATISUserDAO;
import edu.eci.cvds.persistence.mybatis.dao.UserDAO;
import edu.eci.cvds.security.Login;
import edu.eci.cvds.security.ShiroLogin;
import edu.eci.cvds.services.impl.ServicesImpl;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import static com.google.inject.Guice.createInjector;

/**
 * @author Laura Valentina García León
 * @author Laura Nathalia García
 * @author Juan Sebastián Cadavid
 * @author Juan David Murillo
 * @version 15/10/2021
 */
public class ServicesFactory {
    private static ServicesFactory instance = new ServicesFactory();

    private static Injector injector;

    private static Injector testInjector;

    private ServicesFactory(){
        injector = createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setEnvironmentId("development");
                setClassPathResource("mybatis-config.xml");

                // DAO
                bind(Login.class).to(ShiroLogin.class);
                bind(UserDAO.class).to(MyBATISUserDAO.class);

                // SERVICES
                bind(Services.class).to(ServicesImpl.class);

            }
        });

        testInjector = createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setEnvironmentId("test");
                setClassPathResource("h2-mybatis-config.xml");
            }
        });
    }

    public ServicesFactory getServices(){
        return injector.getInstance(ServicesFactory.class);
    }

    public ServicesFactory getServicesTesting(){
        return testInjector.getInstance(ServicesFactory.class);
    }

    public static ServicesFactory getInstance(){
        return instance;
    }
}
