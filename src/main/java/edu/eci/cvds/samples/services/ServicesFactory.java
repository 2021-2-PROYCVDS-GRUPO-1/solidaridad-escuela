package edu.eci.cvds.samples.services;

import com.google.inject.Injector;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import static com.google.inject.Guice.createInjector;

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
