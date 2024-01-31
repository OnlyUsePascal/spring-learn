package example.Util;

import example.Model.Customer;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDao {
  @Autowired
  private SessionFactory sessionFactory;
  
  @Transactional
  public List<Customer> getCustomers(){
    Session session = sessionFactory.getCurrentSession();
    String cmd = "from Customer";
    List<Customer> customers = session.createQuery(cmd, Customer.class).getResultList();
    return customers;
  }
}
