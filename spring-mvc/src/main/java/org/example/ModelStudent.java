package org.example;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ModelStudent {

  @NotNull(message = "should not null bro")
  @Size(min = 2, message = "should be longer than 2 char bro")
  private String firstName;

  @Min(value = 5, message = "should be older bro")
  private int age;

  public ModelStudent(){
  }

  public void setFirstName(String firstName) {
    System.out.println("> set first name");
    this.firstName = firstName;
  }

  public void setAge(int age) {
    System.out.println("> set age");
    this.age = age;
  }

  public String getFirstName() {
    System.out.println("> get name");
    return firstName;
  }

  public int getAge() {
    System.out.println("> get age");
    return age;
  }

  @Override
  public String toString() {
    return "ModelStudent{" +
            "firstName='" + firstName + '\'' +
            ", age=" + age +
            '}';
  }
}
