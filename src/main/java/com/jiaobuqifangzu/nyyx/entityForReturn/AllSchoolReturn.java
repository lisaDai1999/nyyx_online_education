package com.jiaobuqifangzu.nyyx.entityForReturn;

import com.jiaobuqifangzu.nyyx.domain.School;

import java.util.List;

public class AllSchoolReturn {
    int code;
    String msg;
    List<School> data;

    public AllSchoolReturn(int code, String msg, List<School> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public AllSchoolReturn() {

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

    public List<School> getData() {
        return data;
    }

    public void setData(List<School> data) {
        this.data = data;
    }
}
