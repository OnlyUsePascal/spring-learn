package org.example.ManyToMany;

import jakarta.persistence.Entity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.Set;
import org.reflections.Reflections;

public class Main {
  
  public static void main(String[] args) {
    // config
    Configuration configuration = new Configuration();
    Set<Class<?>> classSet = new Reflections("org.example.ManyToMany").getTypesAnnotatedWith(Entity.class);
    String configFile = "hibernate.cfg.xml";
    
    classSet.forEach(configuration::addAnnotatedClass);
    SessionFactory sessionFactory = configuration
        .configure(configFile)
        .buildSessionFactory();
    
    
    // class init
    Course c1, c2;
    Student st1, st2;
    
    // try running
    Session session = null;
    try {
      session = sessionFactory.getCurrentSession();
      Transaction transaction = session.beginTransaction();
      
      // c1 = session.get(Course.class, 2);
      // c2 = session.get(Course.class, 3);
      // st1 = session.get(Student.class, 1);
      // st2 = session.get(Student.class, 2);
      
      // st1.addCourse(c1);
      // c2.addStudent(st1);
      // c1.addStudent(st2);
      
      // session.remove(c1);
      // session.remove(c1);
      
      transaction.commit();
    } catch (Exception err){
      err.printStackTrace();
    } finally {
      session.close();
      sessionFactory.close();
    }
  }
  
}
