package com.jiaobuqifangzu.nyyx.entityForReturn;

import java.util.List;

/**
 * @author ChenXing
 * @date 2020/10/23 10:08
 */
public class CommentRe {
    private int code;//返回代码：0为成功  1为失败
    private String msg;//返回信息
    private List<UserComments> data;

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

    public List<UserComments> getData() {
        return data;
    }

    public void setData(List<UserComments> data) {
        this.data = data;
    }
}
