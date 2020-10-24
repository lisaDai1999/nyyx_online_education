package com.jiaobuqifangzu.nyyx.entityForReturn;

/**
 * @author ChenXing
 * @date 2020/10/22 15:42
 */
public class VideoInfo {
    private String video_route;
    private String cover_route;
    private String video_name;
    private String brief_introduction;

    public VideoInfo() {
    }

    public VideoInfo(String video_route, String cover_route, String video_name, String brief_introduction) {
        this.video_route = video_route;
        this.cover_route = cover_route;
        this.video_name = video_name;
        this.brief_introduction = brief_introduction;
    }

    public String getVideo_route() {
        return video_route;
    }

    public void setVideo_route(String video_route) {
        this.video_route = video_route;
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
