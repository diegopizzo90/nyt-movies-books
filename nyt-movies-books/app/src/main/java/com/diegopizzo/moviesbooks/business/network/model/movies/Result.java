package com.diegopizzo.moviesbooks.business.network.model.movies;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by diegopizzo on 16/11/2017.
 */

@Parcel
public class Result {

    @SerializedName("display_title")
    @Expose
    String displayTitle;
    @SerializedName("byline")
    @Expose
    String byline;
    @SerializedName("headline")
    @Expose
    String headline;
    @SerializedName("multimedia")
    @Expose
    Multimedia multimedia;

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
}
