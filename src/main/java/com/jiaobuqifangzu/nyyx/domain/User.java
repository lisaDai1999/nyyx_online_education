package com.jiaobuqifangzu.nyyx.domain;


import lombok.Cleanup;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity

@Table(name = "user")
public class User {

  //用户id
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  @Column(name = "id")
  private Integer id;

  //用户电话号码
  @Column(name = "phone_num")
  private String phoneNum;

  //用户名
  @Column(name = "username")
  private String username;

  //密码
  @Column(name = "password")
  private String password;

  //性别
  @Column(name = "sex")
  private String sex;

  //用户类型 0学生 1老师
  @Column(name = "user_type")
  private Integer user_type;

  //头像地址
  @Column(name = "head_img")
  private String head_img;

  //证件照地址
  @Column(name = "certificates")
  private String certificates;

  //学校号
  @Column(name = "school_id")
  private Integer school_id;

  //创建时间
  @Column(name = "create_time")
  private Date create_time;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getPhoneNum() {
    return phoneNum;
  }

  public void setPhoneNum(String phone_num) {
    this.phoneNum = phone_num;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public Integer getUser_type() {
    return user_type;
  }

  public void setUser_type(Integer user_type) {
    this.user_type = user_type;
  }

  public String getHead_img() {
    return head_img;
  }

  public void setHead_img(String head_img) {
    this.head_img = head_img;
  }

  public String getCertificates() {
    return certificates;
  }

  public void setCertificates(String certificates) {
    this.certificates = certificates;
  }

  public Integer getSchool_id() {
    return school_id;
  }

  public void setSchool_id(Integer school_id) {
    this.school_id = school_id;
  }

  public Date getCreate_time() {
    return create_time;
  }

  public void setCreate_time(Date create_time) {
    this.create_time = create_time;
  }



}
