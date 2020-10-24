package com.jiaobuqifangzu.nyyx.domain;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)//标注主键，且为自增长型
  @Column(name = "id")
  private int id;

  @Column(name = "user_id")
  private int user_id;

  @Column(name = "video_id")
  private int video_id;
  @Column(name = "text")
  private String text;

  @Column(name = "create_time")
  private Date createTime;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public int getUser_id() {
    return user_id;
  }

  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }

  public int getVideo_id() {
    return video_id;
  }

  public void setVideo_id(int video_id) {
    this.video_id = video_id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }


  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

}
