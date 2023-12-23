package org.example.OneToMany;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;
  @Column(name = "title")
  private String title;
  @ManyToOne(cascade = {CascadeType.DETACH,
          CascadeType.MERGE,
          CascadeType.PERSIST,
          CascadeType.REFRESH})
  @JoinColumn(name = "instructorId")
  private Instructor instructor;
  @OneToMany(cascade = {CascadeType.DETACH,
      CascadeType.MERGE,
      CascadeType.PERSIST,
      CascadeType.REMOVE,
      CascadeType.REFRESH},
      mappedBy = "course",
      fetch = FetchType.EAGER)
  List<Comment> commentList;
  
  public Course() {
    System.out.println("* course created");
  }

  public Course(String title) {
    this.title = title;
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

  public Instructor getInstructor() {
    return instructor;
  }

  public void setInstructor(Instructor instructor) {
    this.instructor = instructor;
  }
  
  public void addComment(Comment comment){
    if (commentList == null) commentList = new ArrayList<>();
    commentList.add(comment);
    comment.setCourse(this);
  }
  
  public List<Comment> getCommentList() {
    return commentList;
  }
  
  @Override
  public String toString() {
    return "Course{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", instructor=" + instructor +
        ", commentList=" + commentList +
        '}';
  }
}
