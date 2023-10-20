package org.example.OneToOne;

import jakarta.persistence.*;

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
  InstructorDetail instructorDetail;

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


  @Override
  public String toString() {
    return "Instructor{" +
            "id=" + id +
            ", mainName='" + mainName + '\'' +
            '}';
  }
}
