package com.jiaobuqifangzu.nyyx.req;

/**
 * 接收前端传入参数
 */
public class Regreq {
    String phone_num;
    String user_name;
    String password;
    String sex;
    String head_img;
    Integer user_type;
    String certificates;
    Integer school_id;

    public Regreq(String phone_num, String user_name, String password, String sex, String head_img, Integer user_type, String certificates, Integer school_id) {
        this.phone_num = phone_num;
        this.user_name = user_name;
        this.password = password;
        this.sex = sex;
        this.head_img = head_img;
        this.user_type = user_type;
        this.certificates = certificates;
        this.school_id = school_id;
    }

    public Regreq() {
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
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

    public String getHead_img() {
        return head_img;
    }

    public void setHead_img(String head_img) {
        this.head_img = head_img;
    }

    public Integer getUser_type() {
        return user_type;
    }

    public void setUser_type(Integer user_type) {
        this.user_type = user_type;
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
}
