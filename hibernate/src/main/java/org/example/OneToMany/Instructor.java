package org.example.OneToMany;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructor")
public class Instructor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;
  @Column(name = "mainName")
  private String mainName;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "detail_id")
  private InstructorDetail instructorDetail;
  @OneToMany(cascade = {CascadeType.DETACH,
    CascadeType.MERGE,
    CascadeType.PERSIST,
    CascadeType.REFRESH},
    mappedBy = "instructor")
  private List<Course> courses;

  public Instructor() {
  }

  public Instructor(String mainName) {
    this.mainName = mainName;
  }

  public InstructorDetail getInstructorDetail() {
    return instructorDetail;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getMainName() {
    return mainName;
  }

  public void setMainName(String mainName) {
    this.mainName = mainName;
  }

  public void setInstructorDetail(InstructorDetail instructorDetail) {
    this.instructorDetail = instructorDetail;
  }

  public List<Course> getCourses() {
    return courses;
  }

  public void addCourse(Course course) {
    if (courses == null) {
      courses = new ArrayList<>();
    }

    courses.add(course);
    course.setInstructor(this);
  }

  @Override
  public String toString() {
    return "Instructor{" +
            "id=" + id +
            ", mainName='" + mainName + '\'' +
            '}';
  }
}
