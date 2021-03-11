package com.example.camhoa;

public class Theme {
    private String imgBackgroud;
    private String tvName;

    public Theme(String imgBackgroud, String tvName) {
        this.imgBackgroud = imgBackgroud;
        this.tvName = tvName;
    }

    public String getImgBackgroud() {
        return imgBackgroud;
    }

    public void setImgBackgroud(String imgBackgroud) {
        this.imgBackgroud = imgBackgroud;
    }

    public String getTvName() {
        return tvName;
    }

    public void setTvName(String tvName) {
        this.tvName = tvName;
    }
}
