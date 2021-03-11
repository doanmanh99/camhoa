package com.example.camhoa;

public class User {
    private String imgSample;
    private String imgAvatar;
    private String tvName;

    public User(String imgSample, String imgAvatar, String tvName) {
        this.imgSample = imgSample;
        this.imgAvatar = imgAvatar;
        this.tvName = tvName;
    }

    public String getImgSample() {
        return imgSample;
    }

    public void setImgSample(String imgSample) {
        this.imgSample = imgSample;
    }

    public String getImgAvatar() {
        return imgAvatar;
    }

    public void setImgAvatar(String imgAvatar) {
        this.imgAvatar = imgAvatar;
    }

    public String getTvName() {
        return tvName;
    }

    public void setTvName(String tvName) {
        this.tvName = tvName;
    }
}
