package com.jiaobuqifangzu.nyyx.entityForReturn;

/**
 * @author ChenXing
 * @date 2020/10/18 18:16
 */

public class FileReturn {
    /**
     * code：整型数据，返回的代码，
     * 0为查询成功
     * 1为查询失败
     * msg：字符串，code对应的说明，
     * code == 0，“获取成功”
     * code == 1，“获取失败”
     */
    private int code;
    private String msg;
    private String data;

    public FileReturn(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public FileReturn() {

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
