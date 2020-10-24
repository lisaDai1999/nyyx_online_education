package com.jiaobuqifangzu.nyyx.somePropertiesInData;

/**
 * 作者：卢芮
 * 根据课程id查询用户返回的数据
 */
public class CourseUserData {

    int user_id;
    String username;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public CourseUserData() {
    }

    public CourseUserData(int user_id, String username) {
        this.user_id = user_id;
        this.username = username;
    }
}
