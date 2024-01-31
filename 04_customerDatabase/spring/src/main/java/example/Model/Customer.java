package example.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "Customer")
public class Customer implements Serializable {
  @Column(name = "name")
  private String name;
  @Column(name = "email")
  @Id
  private String email;
  
  public Customer(){
  
  }
  
  public Customer(String name, String email) {
    this.name = name;
    this.email = email;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getEmail() {
    return email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  @Override
  public String toString() {
    return "Customer{" +
        "firstName='" + name + '\'' +
        ", email='" + email + '\'' +
        '}';
  }
}
