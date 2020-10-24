package com.jiaobuqifangzu.nyyx.domain;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_course")
public class UserCourse {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)//标注主键，且为自增长型
  @Column(name = "id")
  private int id;
  @Column(name = "user_id")
  private int userId;
  @Column(name = "course_id")
  private int courseId;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }


  public int getCourseId() {
    return courseId;
  }

  public void setCourseId(int courseId) {
    this.courseId = courseId;
  }

}
