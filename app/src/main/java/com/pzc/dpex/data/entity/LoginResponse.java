package com.pzc.dpex.data.entity;

public class LoginResponse {

    private int code;
    private String message;
    private String data;

    public LoginResponse() {
    }

    public LoginResponse(int code, String msg, String account) {
        this.code = code;
        this.message = msg;
        this.data = account;
    }

    public int getCode() {
        return code;
    }

    public String getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
