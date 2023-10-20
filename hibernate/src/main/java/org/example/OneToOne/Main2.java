package org.example.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main2 {
  static Session session;
  public static void main(String[] args) {
    String configFileName = "hibernate.cfg.xml";
    SessionFactory sessionFactory = new Configuration()
            .configure(configFileName)
            .buildSessionFactory();

    Instructor instructor = new Instructor("jeff");
    InstructorDetail instructorDetail = new InstructorDetail("jaff");
    instructor.setInstructorDetail(instructorDetail);

    try {
      session = sessionFactory.getCurrentSession();
      session.beginTransaction();

      session.persist(instructor);

      session.getTransaction().commit();
      session.close();
    } catch (Exception err) {
      err.printStackTrace();
    }
  }
}
