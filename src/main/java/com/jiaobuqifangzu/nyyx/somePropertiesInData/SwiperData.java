package com.jiaobuqifangzu.nyyx.somePropertiesInData;

/**
 * 轮播图列表对象
 * 作者：卢芮
 */
public class SwiperData {

    Integer id;
    String cover_route;

    public SwiperData(Integer id, String cover_route) {
        this.id = id;
        this.cover_route = cover_route;
    }

    public SwiperData() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCover_route() {
        return cover_route;
    }

    public void setCover_route(String cover_route) {
        this.cover_route = cover_route;
    }
}
