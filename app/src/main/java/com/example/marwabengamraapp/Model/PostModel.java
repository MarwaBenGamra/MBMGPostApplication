package com.example.marwabengamraapp.Model;

public class PostModel {

    private String name;
    private String short_desc;
    private String long_desc;
    private String app_icon_url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShort_desc() {
        return short_desc;
    }

    public void setShort_desc(String short_desc) {
        this.short_desc = short_desc;
    }

    public String getLong_desc() {
        return long_desc;
    }

    public void setLong_desc(String long_desc) {
        this.long_desc = long_desc;
    }

    public String getApp_icon_url() {
        return app_icon_url;
    }

    public void setApp_icon_url(String app_icon_url) {
        this.app_icon_url = app_icon_url;
    }
}
