package com.diegopizzo.moviesbooks.business.network.model.movies;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by diegopizzo on 16/11/2017.
 */

public class Multimedia {

    @SerializedName("src")
    @Expose
    private String src;
    @SerializedName("width")
    @Expose
    private int width;
    @SerializedName("height")
    @Expose
    private int height;

    public String getSrc() {
        return src;
    }

    public void setSrc(final String src) {
        this.src = src;
    }

    public Multimedia withSrc(final String src) {
        this.src = src;
        return this;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(final int width) {
        this.width = width;
    }

    public Multimedia withWidth(final int width) {
        this.width = width;
        return this;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(final int height) {
        this.height = height;
    }

    public Multimedia withHeight(final int height) {
        this.height = height;
        return this;
    }
}
