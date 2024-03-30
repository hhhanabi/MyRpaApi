package com.example.myrpaapi.constant;
import lombok.Data;
import java.io.Serializable;

@Data
public class ResultJson<T> implements Serializable {

    private static final long serialVersionUID = 783015033603078674L;
    private int code;
    private String msg;
    private T data;

    public static ResultJson ok() {
        return ok("");
    }

    public static ResultJson ok(Object o) {
        return new ResultJson(ResultCode.SUCCESS, o);
    }

    public static ResultJson failure(ResultCode code) {
        return failure(code, "");
    }

    public static ResultJson failure(ResultCode code, Object o) {
        return new ResultJson(code, o);
    }

    public static ResultJson failure(ResultCode code, String message) {
        return new ResultJson(code, message);
    }

    public static ResultJson failure(Integer code, String message) {
        return new ResultJson(code, message);
    }

    public ResultJson(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public ResultJson(ResultCode resultCode) {
        setResultCode(resultCode);
    }

    public ResultJson(ResultCode resultCode, String message) {
        this.code = resultCode.getCode();
        this.msg = message;
    }

    public ResultJson(ResultCode resultCode, T data) {
        setResultCode(resultCode);
        this.data = data;
    }

    public ResultJson(int code, String message, T data) {
        this.code = code;
        this.msg = message;
        this.data = data;
    }

    public ResultJson(Integer code, String message) {
        this.code = code;
        this.msg = message;
    }

    public void setResultCode(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMessage();
    }

    @Override
    public String toString() {
        return "{" +
                "\"code\":" + code +
                ", \"msg\":\"" + msg + '\"' +
                ", \"data\":\"" + data + '\"' +
                '}';
    }
}
