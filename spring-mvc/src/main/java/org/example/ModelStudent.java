package org.example;

public class ModelStudent {

  public String firstName;
  public int age;

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
