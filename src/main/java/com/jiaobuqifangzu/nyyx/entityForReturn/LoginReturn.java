package com.jiaobuqifangzu.nyyx.entityForReturn;

import com.jiaobuqifangzu.nyyx.somePropertiesInData.LoginData;

/**
 * 登录返回数据封装类
 */
public class LoginReturn {

    //返回标识，0为成功，1为用户不存在，2 为密码错误
    int code;
    //返回消息
    String msg;

    LoginData data;

    public LoginReturn() {
    }

    public LoginReturn(int code, String msg, LoginData data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public LoginReturn(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public LoginData getData() {
        return data;
    }

    public void setData(LoginData data) {
        this.data = data;
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
