package com.jiaobuqifangzu.nyyx.Utils;

//错误信息类
public class UnifyResponse {

    private int code;
    private String message;
    private String requestUri;

    public UnifyResponse(int code, String message, String requestUri){
        this.code = code;
        this.message = message;
        this.requestUri = requestUri;
    }
}
