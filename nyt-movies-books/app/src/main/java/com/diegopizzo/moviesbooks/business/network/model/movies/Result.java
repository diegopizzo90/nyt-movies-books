package com.diegopizzo.moviesbooks.business.network.model.movies;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by diegopizzo on 16/11/2017.
 */

public class Result implements Parcelable {

    public static final Parcelable.Creator<Result> CREATOR
            = new Parcelable.Creator<Result>() {
        @Override
        public Result createFromParcel(final Parcel in) {
            return new Result(in);
        }

        @Override
        public Result[] newArray(final int size) {
            return new Result[size];
        }
    };

    @SerializedName("display_title")
    @Expose
    private String displayTitle;
    @SerializedName("byline")
    @Expose
    private String byline;
    @SerializedName("headline")
    @Expose
    private String headline;
    @SerializedName("multimedia")
    @Expose
    private Multimedia multimedia;

    private Result(final Parcel in) {
        displayTitle = in.readString();
        byline = in.readString();
        headline = in.readString();
        multimedia = (Multimedia) in.readParcelable(Multimedia.class.getClassLoader());
    }

    public String getDisplayTitle() {
        return displayTitle;
    }

    public void setDisplayTitle(final String displayTitle) {
        this.displayTitle = displayTitle;
    }

    public Result withDisplayTitle(final String displayTitle) {
        this.displayTitle = displayTitle;
        return this;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(final String byline) {
        this.byline = byline;
    }

    public Result withByline(final String byline) {
        this.byline = byline;
        return this;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(final String headline) {
        this.headline = headline;
    }

    public Result withHeadline(final String headline) {
        this.headline = headline;
        return this;
    }

    public Multimedia getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(final Multimedia multimedia) {
        this.multimedia = multimedia;
    }

    public Result withMultimedia(final Multimedia multimedia) {
        this.multimedia = multimedia;
        return this;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeString(displayTitle);
        dest.writeString(byline);
        dest.writeString(headline);
        dest.writeParcelable(multimedia, flags);
    }
}
