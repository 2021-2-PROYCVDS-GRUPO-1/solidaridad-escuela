package edu.eci.cvds.managedbeans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "testBean")
@ApplicationScoped
public class TestBean {
    String testTitle = "";

    public TestBean() {
        this.setTestTitle("El bean está funcionando correctamente");
    }

    public String getTestTitle() {
        return testTitle;
    }

    public void setTestTitle(String testTitle) {
        this.testTitle = testTitle;
    }
}
