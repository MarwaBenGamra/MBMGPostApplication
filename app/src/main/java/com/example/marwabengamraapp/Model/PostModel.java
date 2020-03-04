package com.example.marwabengamraapp.Model;

import java.util.ArrayList;
import java.util.List;

public class PostModel {

    private String app_id;
    private String name;
    private String short_desc;
    private String long_desc;
    private String app_icon_url;
    private int total_ratings;

    private List<ImageModel> app_images = new ArrayList<>();

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

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public int getTotal_ratings() {
        return total_ratings;
    }

    public void setTotal_ratings(int total_ratings) {
        this.total_ratings = total_ratings;
    }

    public List<ImageModel> getApp_images() {
        return app_images;
    }

    public void setApp_images(List<ImageModel> app_images) {
        this.app_images = app_images;
    }

    public class ImageModel {

        private int id;
        private int order_id;
        private String image_url;

        public String getImage_url() {
            return image_url;
        }
    }
}
