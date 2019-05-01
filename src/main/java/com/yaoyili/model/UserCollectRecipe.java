package com.yaoyili.model;

public class UserCollectRecipe {
    private Integer uid;

    private Integer repid;

    public UserCollectRecipe() {
    }

    public UserCollectRecipe(Integer uid, Integer repid) {
        this.uid = uid;
        this.repid = repid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getRepid() {
        return repid;
    }

    public void setRepid(Integer repid) {
        this.repid = repid;
    }
}