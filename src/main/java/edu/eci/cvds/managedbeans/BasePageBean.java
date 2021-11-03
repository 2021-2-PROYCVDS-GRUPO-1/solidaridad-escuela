package edu.eci.cvds.managedbeans;

import com.google.inject.Injector;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import java.io.Serializable;

public class BasePageBean implements Serializable {
    private Injector injector;

    public Injector getInjector(){
        System.out.println("  ");
        System.out.println(" ------- ");
        System.out.println(injector);
        System.out.println(" ------- ");
        System.out.println("  ");

        if (injector == null){
            // $ -> esto está llegando null
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            injector = (Injector) servletContext.getAttribute(Injector.class.getName());

            System.out.println("  ");
            System.out.println(" ------- ");
            System.out.println(injector);
            System.out.println(" ------- ");
            System.out.println("  ");
        }
        return injector;
    }

    public void setInjector(Injector injector){
        this.injector = injector;
    }

    @PostConstruct
    public void init(){
        this.getInjector().injectMembers(this);
    }
}
