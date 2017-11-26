package com.diegopizzo.moviesbooks.business.network.model.movies;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by diegopizzo on 16/11/2017.
 */

@Parcel
public class Multimedia {

    @SerializedName("src")
    @Expose
    String src;
    @SerializedName("width")
    @Expose
    int width;
    @SerializedName("height")
    @Expose
    int height;

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
