package com.yaoyili.model;

public class ShareDetail {
    private Integer sid;

    private String detail;

    public ShareDetail() {
    }

    public ShareDetail(Integer sid, String detail) {
        this.sid = sid;
        this.detail = detail;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}