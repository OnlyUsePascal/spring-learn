package org.example.OneToMany;

import jakarta.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;
  @Column(name = "content")
  private String content;
  @ManyToOne(cascade = {CascadeType.DETACH,
      CascadeType.MERGE,
      CascadeType.PERSIST,
      CascadeType.REFRESH})
  @JoinColumn(name = "courseId")
  private Course course;
  
  public Comment() {
  }
  
  public Comment(String content) {
    this.content = content;
    course = null;
  }
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getContent() {
    return content;
  }
  
  public void setContent(String content) {
    this.content = content;
  }
  
  public Course getCourse() {
    return course;
  }
  
  public void setCourse(Course course) {
    this.course = course;
  }
  
  @Override
  public String toString() {
    return "Comment{" +
        "id=" + id +
        ", content='" + content + '\'' +
        '}';
  }
}
