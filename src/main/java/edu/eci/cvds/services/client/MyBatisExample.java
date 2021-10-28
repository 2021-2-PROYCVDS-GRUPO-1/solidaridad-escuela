package edu.eci.cvds.services.client;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

public class MyBatisExample {
    // mvn exec:java -"Dexec.mainClass"=edu.eci.cvds.samples.services.client.MyBatisExample -"Dexec.cleanupDaemonThreads"=false
    // TODO -> agregar documentación
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


    public static void main(String[] args) throws SQLException {
        System.out.println(" ");
        System.out.println("¡Bienvenido!");
        System.out.println(" ");

        try {
            SqlSessionFactory sessionfact = getSqlSessionFactory();

            SqlSession sqlss = sessionfact.openSession();

            sqlss.commit();
            sqlss.close();
        }
        catch (Exception e){
            throw new SQLException(e.getMessage(),e);
        }
    }
}
