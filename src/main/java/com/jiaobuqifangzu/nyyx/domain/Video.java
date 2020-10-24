package com.jiaobuqifangzu.nyyx.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@Table(name = "video")
public class Video {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)//标注主键，且为自增长型
  @Column(name = "id")
  private int id;

  @Column(name = "video_name")
  private String video_title;

  @Column(name = "course_id")
  private int course_id;

  @Column(name = "video_route")
  private String video_route;

  @Column(name = "cover_route")
  private String cover_route;

  @Column(name = "create_time")
  private Date createTime;

  @Column(name = "brief_introduction")
  private String brief_introduction;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getVideo_title() {
    return video_title;
  }

  public void setVideo_title(String video_title) {
    this.video_title = video_title;
  }

  public int getCourse_id() {
    return course_id;
  }

  public void setCourse_id(int course_id) {
    this.course_id = course_id;
  }

  public String getVideo_route() {
    return video_route;
  }

  public void setVideo_route(String video_route) {
    this.video_route = video_route;
  }

  public String getCover_route() {
    return cover_route;
  }

  public void setCover_route(String cover_route) {
    this.cover_route = cover_route;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public String getBrief_introduction() {
    return brief_introduction;
  }

  public void setBrief_introduction(String brief_introduction) {
    this.brief_introduction = brief_introduction;
  }
}
