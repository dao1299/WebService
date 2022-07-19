package com.example.retrofitassignment.network;

import com.squareup.moshi.Json;

import java.io.Serializable;

public class MarsProperty implements Serializable {
    public String id;
    public String type;
    public @Json(name = "img_src")
    String imgSrcUrl;
    public Double price;

    public MarsProperty(String id, String type, String imgSrcUrl, Double price) {
        this.id = id;
        this.type = type;
        this.imgSrcUrl = imgSrcUrl;
        this.price = price;
    }

    @Override
    public String toString() {
        return "MarsProperty{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", imgSrcUrl='" + imgSrcUrl + '\'' +
                ", price=" + price +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return "For " + type;
    }

    public String getImgSrcUrl() {
        return imgSrcUrl;
    }

    public String getPrice() {
        return "$"+String.valueOf(price) + "";
    }
}
