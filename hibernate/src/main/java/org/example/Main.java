package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
  static SessionFactory sessionFactory;
  static Session session;

  public static void main(String[] args) {
    // init config
    String configFileName = "hibernate.cfg.xml";
    sessionFactory = new Configuration()
            .configure(configFileName)
            .buildSessionFactory();

    ModelUser user = new ModelUser(0, "jing");
    session = sessionFactory.getCurrentSession();

    // trial
    try {
      System.out.println("commence tx");
      session.beginTransaction();

      crudQuery();

      System.out.println("tx end");
      session.getTransaction().commit();
    } catch (Exception err){
      err.printStackTrace();
    } finally {
      sessionFactory.close();
    }
  }

  public static void crudSession(){
    System.out.println("* CRUD SESSION");
    // System.out.println("save object");
    // session.persist(user);

    // System.out.println("get obj");
    // return session.get(ModelUser.class, id);

    // System.out.println("update obj");
    // ModelUser user = session.get(ModelUser.class, 13);
    // user.setName("ching chang");

    System.out.println("delete obj");
  }

  public static void crudQuery(){
    System.out.println("* CRUD QUERY");
    String cmd;

    System.out.println("get obj query");
    cmd = "FROM ModelUser u WHERE u.id < 100";
    List<ModelUser> users = session.createQuery(cmd, ModelUser.class)
            .getResultList();
    for (ModelUser user : users) System.out.println(user);

    // System.out.println("update obj query");
    // cmd = "UPDATE ModelUser SET name='lmao' WHERE id>=220";
    // session.createMutationQuery(cmd).executeUpdate();

  }
}