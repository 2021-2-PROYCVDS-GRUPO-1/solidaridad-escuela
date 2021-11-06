package edu.eci.cvds.managedbeans;

import edu.eci.cvds.entities.Category;
import edu.eci.cvds.persistence.mybatis.mappers.CategoryMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

@ManagedBean(name = "categoryBean")
@ApplicationScoped
public class CategoryBean {

    private String name;
    private String description;
    private String state;

    public static SqlSessionFactory getSqlSessionFactory() {
        SqlSessionFactory sqlSessionFactory = null;
        if (sqlSessionFactory == null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return sqlSessionFactory;
    }

    public void createCategory() throws SQLException {
        try {
            state="incompleto";
            SqlSessionFactory sessionfact = getSqlSessionFactory();

            SqlSession sqlss = sessionfact.openSession();

            CategoryMapper cm = sqlss.getMapper(CategoryMapper.class);
            cm.addCategory("Juan", "java", "incompleto");

            sqlss.commit();

            sqlss.close();
        }
        catch (Exception e){
            throw new SQLException(e.getMessage(),e);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

