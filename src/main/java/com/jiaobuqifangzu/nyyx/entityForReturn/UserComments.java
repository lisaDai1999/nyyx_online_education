package com.jiaobuqifangzu.nyyx.entityForReturn;

/**
 * @author ChenXing
 * @date 2020/10/23 09:57
 */
public class UserComments {
    private int user_id;
    private String username;
    private String date;
    private String head_img;
    private String text;

    public UserComments() {
    }

    public UserComments(int user_id, String username, String date, String head_img, String text) {
        this.user_id = user_id;
        this.username = username;
        this.date = date;
        this.head_img = head_img;
        this.text = text;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHead_img() {
        return head_img;
    }

    public void setHead_img(String head_img) {
        this.head_img = head_img;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
