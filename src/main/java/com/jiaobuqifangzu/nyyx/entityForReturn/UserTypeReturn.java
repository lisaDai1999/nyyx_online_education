package com.jiaobuqifangzu.nyyx.entityForReturn;

import com.jiaobuqifangzu.nyyx.domain.User;

/**
 * 查询用户类型的返回类
 */
public class UserTypeReturn {

    int code;
    String msg;
    User data;

    public UserTypeReturn(int code, String msg, User data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public UserTypeReturn() {
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

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }
}
