package com.jiaobuqifangzu.nyyx.entityForReturn;

public class UserInfoReturn {

    int code;
    String msg;
    UserSchool data;

    public UserInfoReturn(int code, String msg, UserSchool data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public UserInfoReturn() {
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

    public UserSchool getData() {
        return data;
    }

    public void setData(UserSchool data) {
        this.data = data;
    }
}
