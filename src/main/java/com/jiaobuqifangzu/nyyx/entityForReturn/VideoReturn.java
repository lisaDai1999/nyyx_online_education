package com.jiaobuqifangzu.nyyx.entityForReturn;

/**
 * @author ChenXing
 * @date 2020/10/18 19:51
 */
public class VideoReturn {
    /**
     * id：视频id
     * cover_route：视频封面
     * video_name：视频名
     * brief_introduction：视频简介
     */
    private int id;
    private String cover_route;
    private String video_name;
    private String brief_introduction;

    public VideoReturn() {
    }

    public VideoReturn(int id, String cover_route, String video_name, String brief_introduction) {
        this.id = id;
        this.cover_route = cover_route;
        this.video_name = video_name;
        this.brief_introduction = brief_introduction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCover_route() {
        return cover_route;
    }

    public void setCover_route(String cover_route) {
        this.cover_route = cover_route;
    }

    public String getVideo_name() {
        return video_name;
    }

    public void setVideo_name(String video_name) {
        this.video_name = video_name;
    }

    public String getBrief_introduction() {
        return brief_introduction;
    }

    public void setBrief_introduction(String brief_introduction) {
        this.brief_introduction = brief_introduction;
    }
}
