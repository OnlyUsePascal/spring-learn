package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class ModelUser {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "name")
  private String name;

  public ModelUser(){}

  public ModelUser(int id, String name) {
    this.id = id;
    this.name = name;
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
    return "ModelUser{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
  }
}
