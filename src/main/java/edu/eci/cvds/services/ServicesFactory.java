package edu.eci.cvds.services;

import com.google.inject.Injector;
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
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("THIS IS WORKINGGGG");
        System.out.println(" ");
        System.out.println(" ");

        injector = createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setEnvironmentId("development");
                setClassPathResource("mybatis-config.xml");
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
