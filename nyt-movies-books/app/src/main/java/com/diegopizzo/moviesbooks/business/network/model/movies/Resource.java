package com.diegopizzo.moviesbooks.business.network.model.movies;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by diegopizzo on 16/11/2017.
 */

public class Resource {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("src")
    @Expose
    private String src;
    @SerializedName("height")
    @Expose
    private int height;
    @SerializedName("width")
    @Expose
    private int width;

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public Resource withType(final String type) {
        this.type = type;
        return this;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(final String src) {
        this.src = src;
    }

    public Resource withSrc(final String src) {
        this.src = src;
        return this;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(final int height) {
        this.height = height;
    }

    public Resource withHeight(final int height) {
        this.height = height;
        return this;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(final int width) {
        this.width = width;
    }

    public Resource withWidth(final int width) {
        this.width = width;
        return this;
    }
}
