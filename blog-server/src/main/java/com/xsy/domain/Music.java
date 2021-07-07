package com.xsy.domain;

public class Music {

    private Integer id;
    private String name;
    private String artist;
    private String cover;
    private String url;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist == null ? null : artist.trim();
    }
    public String getCover() {
        return cover;
    }
    public void setCover(String cover) {
        this.cover = cover == null ? null : cover.trim();
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}