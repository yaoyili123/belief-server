package com.yaoyili.controller;

public class ShareInfoResponse {
    private Integer sid;

    private Integer uid;

    private String title;

    private String photoUrl;

    private String author;

    private String headUrl;

    private String content;

    public ShareInfoResponse() {
    }

    public ShareInfoResponse(Integer sid, Integer uid, String title, String photoUrl, String author, String headUrl) {
        this.sid = sid;
        this.uid = uid;
        this.title = title;
        this.photoUrl = photoUrl;
        this.author = author;
        this.headUrl = headUrl;
    }

    public ShareInfoResponse(Integer sid, Integer uid, String title, String photoUrl, String author, String headUrl, String content) {
        this.sid = sid;
        this.uid = uid;
        this.title = title;
        this.photoUrl = photoUrl;
        this.author = author;
        this.headUrl = headUrl;
        this.content = content;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
