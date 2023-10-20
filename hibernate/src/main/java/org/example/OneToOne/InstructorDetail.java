package org.example.OneToOne;

import jakarta.persistence.*;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;
  @Column(name = "otherName")
  private String otherName;

  public InstructorDetail() {
  }

  public InstructorDetail(String otherName) {
    this.otherName = otherName;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getOtherName() {
    return otherName;
  }

  public void setOtherName(String otherName) {
    this.otherName = otherName;
  }

  @Override
  public String toString() {
    return "InstructorDetail{" +
            "id=" + id +
            ", otherName='" + otherName + '\'' +
            '}';
  }
}
