package com.jiaobuqifangzu.nyyx.entityForReturn;

import java.util.List;

/**
 * @author ChenXing
 * @date 2020/10/18 19:49
 */
public class VideoListReturn {
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
    private List<VideoReturn> data;

    public VideoListReturn(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public VideoListReturn() {

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

    public List<VideoReturn> getData() {
        return data;
    }

    public void setData(List<VideoReturn> data) {
        this.data = data;
    }
}
