package com.xsy.domain;

public class Comment {

    private Integer cid;
    private String username;
    private String date;
    private Integer aId;
    private String comment;
    public Integer getCid() {
        return cid;
    }
    public void setCid(Integer cid) {
        this.cid = cid;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }
    public Integer getaId() {
        return aId;
    }
    public void setaId(Integer aId) {
        this.aId = aId;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}