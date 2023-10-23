package org.example.OneToOne;

import jakarta.persistence.Entity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.reflections.Reflections;

import java.util.Set;

public class Main2 {
  static Session session;
  public static void main(String[] args) {
    // class scanner
    Configuration configuration = new Configuration();
    Set<Class<?>> entities = new Reflections("org.example.OneToOne")
            .getTypesAnnotatedWith(Entity.class);
    for (Class<?> entity : entities){
      configuration.addAnnotatedClass(entity);
    }

    // session factory
    String configFileName = "hibernate.cfg.xml";
    SessionFactory sessionFactory = configuration
            .configure(configFileName)
            .buildSessionFactory();

    // Instructor instructor = new Instructor("jeff");
    // InstructorDetail instructorDetail = new InstructorDetail("jaff");
    // instructor.setInstructorDetail(instructorDetail);

    try {
      session = sessionFactory.getCurrentSession();
      session.beginTransaction();

      // InstructorDetail instructorDetail = session.get(InstructorDetail.class, 5);
      // System.out.println(instructorDetail.getInstructor());
      // instructorDetail.getInstructor().setInstructorDetail(null);
      // Instructor instructor = session.get(Instructor.class, 5);
      // InstructorDetail instructorDetail = instructor.getInstructorDetail();
      // instructor.setInstructorDetail(null);
      // session.remove(instructorDetail);

      // instructorDetail.getInstructor();
      // session.persist(instructor);

      session.getTransaction().commit();

    } catch (Exception err) {
      err.printStackTrace();
    } finally {
      session.close();
      sessionFactory.close();
    }
  }
}
