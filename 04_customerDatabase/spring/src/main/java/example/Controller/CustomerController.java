package example.Controller;

import example.Model.Customer;
import example.Util.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
  @Autowired
  private CustomerDao customerDao;
  
  @RequestMapping(value = "/all", produces = "application/json")
  public List<Customer> getCustomers(){
    List<Customer> res = customerDao.getCustomers();
    return res;
  }
  
  @RequestMapping(value = "/all1", produces = "application/json")
  public Customer getCustomers1(){
    Customer customer = new Customer("Joun", "nice@mail.com");
    return customer;
  }
}
