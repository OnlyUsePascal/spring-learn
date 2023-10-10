package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
  public static void main(String[] args) {
    // String dbLink = "jdbc:mysql://localhost:3306/";
    // String db = "test";
    // String url = dbLink + db;
    //
    // String user = "joun";
    // String pwd = "123";
    // try {
    //   Connection connection = DriverManager.getConnection(url, user, pwd);
    //   System.out.println("Connection success!");
    // } catch (Exception err) {
    //   err.printStackTrace();
    // }

    String configFileName = "hibernate.cfg.xml";
    SessionFactory sessionFactory = new Configuration()
            .configure(configFileName)
            .addAnnotatedClass(ModelUser.class)
            .buildSessionFactory();

    // each transaction = 1 session
    Session session = sessionFactory.getCurrentSession();

    try {
      System.out.println("new object");
      ModelUser user = new ModelUser(0, "jang");

      System.out.println("commence tx");
      session.beginTransaction();

      System.out.println("save object");
      session.persist(user);

      System.out.println("tx end");
      session.getTransaction().commit();
    } catch (Exception err) {
      err.printStackTrace();
    } finally {
      sessionFactory.close();
    }

  }
}