package com.jiaobuqifangzu.nyyx.entityForReturn;

import javax.persistence.Column;

//用户信息包含学校信息
public class UserSchool {

    private String phone_num;

    //用户名
    private String username;

    private String school_name;

    //性别
    private String sex;

    //用户类型 0学生 1老师
    private Integer user_type;

    //头像地址
    private String head_img;

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
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
}
