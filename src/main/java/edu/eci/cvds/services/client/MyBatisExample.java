package edu.eci.cvds.services.client;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import edu.eci.cvds.persistence.mybatis.mappers.CategoryMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisExample {
    // mvn exec:java -"Dexec.mainClass"=edu.eci.cvds.samples.services.client.MyBatisExample -"Dexec.cleanupDaemonThreads"=false
    public static void main(String args[]) throws SQLException {
        System.out.println(" ");
        System.out.println("¡Bienvenido!");
        System.out.println(" ");
    }
}