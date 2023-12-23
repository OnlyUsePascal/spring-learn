package org.example.ManyToMany;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "course")
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;
  @Column(name = "title")
  private String title;
  @ManyToMany(fetch = FetchType.LAZY
    , cascade = {CascadeType.DETACH
      , CascadeType.MERGE
      , CascadeType.PERSIST
      , CascadeType.REFRESH})
  @JoinTable(
      name = "course_student"
      , joinColumns = @JoinColumn(name = "course_id")
      , inverseJoinColumns = @JoinColumn(name = "student_id")
  )
  private List<Student> students;
  
  public Course() {
    System.out.println("*course created");
  }
  
  public Course(String title) {
    this.title = title;
  }
  
  public void addStudent(Student student){
    students.add(student);
  }
  
  public List<Student> getStudents() {
    return students;
  }
  
  public void setStudents(List<Student> students) {
    this.students = students;
  }
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getTitle() {
    return title;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }
  
  @Override
  public String toString() {
    return "Course{" +
        "id=" + id +
        ", title='" + title + '\'' +
        '}';
  }
}
