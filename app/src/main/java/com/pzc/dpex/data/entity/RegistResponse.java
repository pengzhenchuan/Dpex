package com.pzc.dpex.data.entity;

public class RegistResponse {
    private int code;
    private String msg;
    private String account;

    public RegistResponse() {
    }

    public RegistResponse(int code, String msg, String account) {
        this.code = code;
        this.msg = msg;
        this.account = account;
    }

    public int getCode() {
        return code;
    }

    public String getAccount() {
        return account;
    }

    public String getMsg() {
        return msg;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
