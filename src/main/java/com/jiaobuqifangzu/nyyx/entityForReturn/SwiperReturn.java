package com.jiaobuqifangzu.nyyx.entityForReturn;

import com.jiaobuqifangzu.nyyx.somePropertiesInData.SwiperData;

import java.util.List;

/**
 * 轮播图返回数据
 * 作者：卢芮
 */
public class SwiperReturn {
    int code;
    String msg;
    List<SwiperData> data;

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

    public List<SwiperData> getData() {
        return data;
    }

    public void setData(List<SwiperData> data) {
        this.data = data;
    }

    public SwiperReturn() {
    }


    public SwiperReturn(int code, String msg, List<SwiperData> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
