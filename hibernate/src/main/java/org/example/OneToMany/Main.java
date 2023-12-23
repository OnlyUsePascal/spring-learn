package org.example.OneToMany;

import jakarta.persistence.Entity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.query.SelectionQuery;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
  static Session session;

  public static void main(String[] args) {
    // class scanner
    Configuration configuration = new Configuration();
    Set<Class<?>> entities = new Reflections("org.example.OneToMany")
            .getTypesAnnotatedWith(Entity.class);
    for (Class<?> entity : entities) {
      configuration.addAnnotatedClass(entity);
    }

    // session factory
    String configFileName = "hibernate.cfg.xml";
    SessionFactory sessionFactory = configuration
            .configure(configFileName)
            .buildSessionFactory();

    // Instructor instructor = new Instructor("joun1");
    // List<Course> courses = new ArrayList<>();
    // Course c1 = new Course("c1");
    // Course c2 = new Course("c2");
    //
    // instructor.addCourse(c1);
    // instructor.addCourse(c2);
    
    Comment cm1 = new Comment("what the fuck");
    Comment cm2 = new Comment("sure thing");

    try {
      session = sessionFactory.getCurrentSession();
      session.beginTransaction();

      // String cmd = "from Course where id = 1";
      // SelectionQuery<Course> query = session.createQuery(cmd, Course.class);
      // Course c = query.getSingleResult();

      Course c = session.get(Course.class, 2);
      Comment cm = c.commentList.get(0);
      session.remove(cm);
      
      // session.persist(instructor);
      // instructor = session.get(Instructor.class, 7);
      // System.out.println(instructor);
      // for (Course course : instructor.getCourses()) System.out.println(course);

      // String cmd = "from Instructor i join i.courses where i.id >= 7";
      // SelectionQuery<Instructor> query  = session.createSelectionQuery(cmd, Instructor.class);
      // // query.setParameter("instructorId", 7);
      // for (Instructor instructor : query.getResultList()) {
      //   System.out.println(instructor);
      //   for (Course course : instructor.getCourses()) System.out.println(course);
      // };



      session.getTransaction().commit();
    } catch (Exception err) {
      err.printStackTrace();
    } finally {
      session.close();
      sessionFactory.close();
    }
  }
}

