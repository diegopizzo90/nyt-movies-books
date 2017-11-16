package com.diegopizzo.moviesbooks.business.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by diegopizzo on 16/11/2017.
 */

public class Result {

    @SerializedName("display_title")
    @Expose
    private String displayTitle;
    @SerializedName("mpaa_rating")
    @Expose
    private String mpaaRating;
    @SerializedName("critics_pick")
    @Expose
    private int criticsPick;
    @SerializedName("byline")
    @Expose
    private String byline;
    @SerializedName("headline")
    @Expose
    private String headline;
    @SerializedName("summary_short")
    @Expose
    private String summaryShort;
    @SerializedName("publication_date")
    @Expose
    private String publicationDate;
    @SerializedName("opening_date")
    @Expose
    private String openingDate;
    @SerializedName("date_updated")
    @Expose
    private String dateUpdated;
    @SerializedName("link")
    @Expose
    private Link link;
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

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(final String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public Result withMpaaRating(final String mpaaRating) {
        this.mpaaRating = mpaaRating;
        return this;
    }

    public int getCriticsPick() {
        return criticsPick;
    }

    public void setCriticsPick(final int criticsPick) {
        this.criticsPick = criticsPick;
    }

    public Result withCriticsPick(final int criticsPick) {
        this.criticsPick = criticsPick;
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

    public String getSummaryShort() {
        return summaryShort;
    }

    public void setSummaryShort(final String summaryShort) {
        this.summaryShort = summaryShort;
    }

    public Result withSummaryShort(final String summaryShort) {
        this.summaryShort = summaryShort;
        return this;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(final String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Result withPublicationDate(final String publicationDate) {
        this.publicationDate = publicationDate;
        return this;
    }

    public String getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(final String openingDate) {
        this.openingDate = openingDate;
    }

    public Result withOpeningDate(final String openingDate) {
        this.openingDate = openingDate;
        return this;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(final String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public Result withDateUpdated(final String dateUpdated) {
        this.dateUpdated = dateUpdated;
        return this;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(final Link link) {
        this.link = link;
    }

    public Result withLink(final Link link) {
        this.link = link;
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
