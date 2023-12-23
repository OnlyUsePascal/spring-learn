package org.example.ManyToMany;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "student")
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;
  @Column(name = "name")
  private String name;
  @ManyToMany(fetch = FetchType.LAZY
    , cascade = {CascadeType.DETACH
      , CascadeType.MERGE
      , CascadeType.PERSIST
      , CascadeType.REFRESH}
  )
  @JoinTable( name = "course_student"
    ,joinColumns = @JoinColumn(name = "student_id")
    ,inverseJoinColumns = @JoinColumn(name = "course_id")
  )
  private List<Course> courses;
  
  public Student() {
    System.out.println("*student created");
  }
  
  public Student(String name) {
    this.name = name;
  }
  
  public void addCourse(Course course){
    courses.add(course);
  }
  
  public List<Course> getCourses() {
    return courses;
  }
  
  public void setCourses(List<Course> courses) {
    this.courses = courses;
  }
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  @Override
  public String toString() {
    return "Student{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
