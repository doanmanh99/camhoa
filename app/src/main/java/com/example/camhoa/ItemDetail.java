package com.example.camhoa;

public class ItemDetail {
    private String imgAvatar;
    private String tvName;
    private String tvDesc;

    public ItemDetail() {
    }

    public ItemDetail(String imgAvatar, String tvName, String tvDesc) {
        this.imgAvatar = imgAvatar;
        this.tvName = tvName;
        this.tvDesc = tvDesc;
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

    public String getTvDesc() {
        return tvDesc;
    }

    public void setTvDesc(String tvDesc) {
        this.tvDesc = tvDesc;
    }
}
