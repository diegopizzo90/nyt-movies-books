package com.diegopizzo.moviesbooks.business.network.model.movies;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by diegopizzo on 16/11/2017.
 */

public class Multimedia implements Parcelable {

    public static final Parcelable.Creator<Multimedia> CREATOR
            = new Parcelable.Creator<Multimedia>() {
        @Override
        public Multimedia createFromParcel(final Parcel in) {
            return new Multimedia(in);
        }

        @Override
        public Multimedia[] newArray(final int size) {
            return new Multimedia[size];
        }
    };

    @SerializedName("src")
    @Expose
    private String src;
    @SerializedName("width")
    @Expose
    private int width;
    @SerializedName("height")
    @Expose
    private int height;

    private Multimedia(final Parcel in) {
        src = in.readString();
        width = in.readInt();
        height = in.readInt();
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeString(src);
        dest.writeInt(width);
        dest.writeInt(height);
    }

}
