package com.jiaobuqifangzu.nyyx.entityForReturn;

/**
 * 删除课程返回类
 */
public class deleteCourseReturn {

    //返回代码
    int code;
    //返回信息
    String msg;


    public deleteCourseReturn() {
    }

    public deleteCourseReturn(int code, String msg) {
        this.code = code;
        this.msg = msg;
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
}
