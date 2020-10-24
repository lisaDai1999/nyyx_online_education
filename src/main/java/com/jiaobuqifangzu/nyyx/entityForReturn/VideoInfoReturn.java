package com.jiaobuqifangzu.nyyx.entityForReturn;

/**
 * @author ChenXing
 * @date 2020/10/22 15:54
 */
public class VideoInfoReturn {
    private int code;
    private String msg;
    private VideoInfo data;

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

    public VideoInfo getData() {
        return data;
    }

    public void setData(VideoInfo data) {
        this.data = data;
    }
}
