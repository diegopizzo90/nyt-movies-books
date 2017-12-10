package com.diegopizzo.moviesbooks.business.network.model.movies.moviesreviews;

import com.diegopizzo.moviesbooks.business.network.model.movies.Multimedia;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by diegopizzo on 16/11/2017.
 */

public class Result {

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
