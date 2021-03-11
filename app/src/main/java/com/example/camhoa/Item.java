package com.example.camhoa;

public class Item {
    private String imgAvatar;
    private String desc;

    public Item() {
    }

    public Item(String imgAvatar, String desc) {
        this.imgAvatar = imgAvatar;
        this.desc = desc;
    }

    public String getImgAvatar() {
        return imgAvatar;
    }

    public void setImgAvatar(String imgAvatar) {
        this.imgAvatar = imgAvatar;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
