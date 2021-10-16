package edu.eci.cvds.samples.services;

import com.google.inject.Injector;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import java.util.Optional;

import static com.google.inject.Guice.createInjector;

public class ServicesFactory {
    private static ServicesFactory instance = new ServicesFactory();

    private static Injector injector;

    private static Injector testInjector;

    private static Optional<Injector> optInjector;

    private Injector myBatisInjector(String env, String pathResource) {

        return null;
        //return createInjector(new XMLMyBatisModule() {
          //  @Override
            //protected void initialize() {
              //  setEnvironmentId(env);
              //  setClassPathResource(pathResource);
                /*bind(ItemDAO.class).to(MyBATISItemDAO.class);
                bind(ClienteDAO.class).to(MyBATISClienteDAO.class);
                bind(TipoItemDAO.class).to(MyBATISTipoItemDAO.class);
                bind(ItemRentadoDAO.class).to(MyBATISItemRentadoDAO.class);
                //bind(ServiciosAlquiler.class).to(ServiciosAlquilerItemsImpl.class);
                bind(ServiciosAlquiler.class).to(ServiciosAlquilerStub.class);*/
            //}
        //});

    }

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
                setClassPathResource("mybatis-config.xml");
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
