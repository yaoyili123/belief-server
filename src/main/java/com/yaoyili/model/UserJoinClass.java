package com.yaoyili.model;

public class UserJoinClass {
    private Integer uid;

    private Integer scid;

    public UserJoinClass(Integer uid, Integer scid) {
        this.uid = uid;
        this.scid = scid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getScid() {
        return scid;
    }

    public void setScid(Integer scid) {
        this.scid = scid;
    }
}