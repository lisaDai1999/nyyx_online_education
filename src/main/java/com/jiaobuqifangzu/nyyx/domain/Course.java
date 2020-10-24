package com.jiaobuqifangzu.nyyx.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//标注主键，且为自增长型
    @Column(name = "id")
    private int id;

    @Column(name = "course_name")
    private String course_name;

    @Column(name = "teacher_id")
    private int teacher_id;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "cover_route")
    private String cover_route;

    @Column(name = "brief_introduction")
    private String brief_introduction;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
