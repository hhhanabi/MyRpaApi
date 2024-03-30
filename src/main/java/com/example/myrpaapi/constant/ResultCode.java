package com.example.myrpaapi.constant;

import lombok.Getter;

@Getter
public enum ResultCode {

    SUCCESS(200, "成功"),
    BAD_REQUEST(403, "参数或者语法不对"),
    UNAUTHORIZED(401, "认证失败"),
    LOGIN_ERROR(401, "登陆失败，用户名或密码无效"),
    FORBIDDEN(403, "禁止访问"),
    NOT_FOUND(404, "请求的资源不存在"),
    OPERATE_ERROR(405, "操作失败，请求操作的资源不存在"),
    TIME_OUT(408, "请求超时"),
    NOT_ALLOWED_LOGIN(401, "登陆失败，该用户无法登录该系统"),
    SERVER_ERROR(500, "服务器内部错误");


    private int code; // HttpRequest返回代号
    private String message; // 返回消息

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}