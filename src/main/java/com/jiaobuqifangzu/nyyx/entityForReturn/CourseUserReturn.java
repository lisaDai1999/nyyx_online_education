package com.jiaobuqifangzu.nyyx.entityForReturn;

import com.jiaobuqifangzu.nyyx.somePropertiesInData.CourseUserData;

import java.util.List;

/**
 * 返回类
 * 当传入课程id时候，返回的用户信息
 */
public class CourseUserReturn {
    int code;
    String msg;
    List<CourseUserData> data;

    public CourseUserReturn(int code, String msg, List<CourseUserData> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public CourseUserReturn() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<CourseUserData> getData() {
        return data;
    }

    public void setData(List<CourseUserData> data) {
        this.data = data;
    }
}
