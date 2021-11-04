package edu.eci.cvds.services;

import com.google.inject.Injector;
import edu.eci.cvds.persistence.mybatis.*;
import edu.eci.cvds.persistence.mybatis.dao.*;
import edu.eci.cvds.security.Log;
import edu.eci.cvds.security.ShiroLogger;
import edu.eci.cvds.services.impl.*;
import org.mybatis.guice.XMLMyBatisModule;

import java.util.Optional;

import static com.google.inject.Guice.createInjector;

public class HistorialServiciosFactory {

    private static HistorialServiciosFactory instance = new HistorialServiciosFactory();
    private static Optional<Injector> optInjector;

    private Injector myBatisInjector(String env, String pathResource) {
        return createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId(env);
                setClassPathResource(pathResource);
                bind(Log.class).to(ShiroLogger.class);
                //DAO
                bind(NovedadDAO.class).to(MyBATISNovedadDAO.class);
                bind(ElementoDAO.class).to(MyBATISElementoDAO.class);
                bind(EquipoDAO.class).to(MyBATISEquipoDAO.class);
                bind(UsuarioDAO.class).to(MyBATISUsuarioDAO.class);
                bind(LaboratorioDAO.class).to(MYBATISLaboratorioDAO.class);
                //Servicios
                bind(HistorialServicios.class).to(HistorialServiciosImpl.class);
                bind(ServiciosEquipo.class).to(ServiciosEquipoImpl.class);
                bind(ServiciosElemento.class).to(ServiciosElementoImpl.class);
                bind(ServiciosLaboratorio.class).to(ServiciosLaboratorioImpl.class);
                bind(ServiciosNovedad.class).to(ServiciosNovedadImpl.class);
            }
        });
    }

    private HistorialServiciosFactory(){
        optInjector = Optional.empty();
    }

    public HistorialServicios getHistorialServicios(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }

        return optInjector.get().getInstance(HistorialServicios.class);
    }

    public HistorialServicios getHistorialServiciosTesting(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("test","mybatis-config-h2.xml"));
        }

        return optInjector.get().getInstance(HistorialServicios.class);
    }


    public ServiciosElemento getServiciosElementoTesting(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("test","mybatis-config-h2.xml"));
        }

        return optInjector.get().getInstance(ServiciosElemento.class);
    }

    public ServiciosEquipo getServiciosEquipoTesting(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("test","mybatis-config-h2.xml"));
        }

        return optInjector.get().getInstance(ServiciosEquipo.class);
    }

    public ServiciosLaboratorio getServiciosLaboratorioTesting(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("test","mybatis-config-h2.xml"));
        }

        return optInjector.get().getInstance(ServiciosLaboratorio.class);
    }

    public ServiciosNovedad getSErviciosNovedadTesting(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("test","mybatis-config-h2.xml"));
        }

        return optInjector.get().getInstance(ServiciosNovedad.class);
    }


    public static HistorialServiciosFactory getInstance(){
        return instance;
    }
}