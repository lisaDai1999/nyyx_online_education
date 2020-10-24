package com.jiaobuqifangzu.nyyx.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "share_files")
public class ShareFiles {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)//标注主键，且为自增长型
  @Column(name = "id")
  private int id;
  @Column(name = "file_name")
  private String fileName;
  @Column(name = "user_id")
  private int userId;
  @Column(name = "file_route")
  private String fileRoute;
  @Column(name = "create_time")
  private Date createTime;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }


  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }


  public String getFileRoute() {
    return fileRoute;
  }

  public void setFileRoute(String fileRoute) {
    this.fileRoute = fileRoute;
  }


  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

}
