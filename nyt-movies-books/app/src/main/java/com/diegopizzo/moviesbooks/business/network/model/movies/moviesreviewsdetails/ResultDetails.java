package com.diegopizzo.moviesbooks.business.network.model.movies.moviesreviewsdetails;

import com.diegopizzo.moviesbooks.business.network.model.movies.moviesreviews.Result;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by diegopizzo on 28/11/2017.
 */

public class ResultDetails extends Result {

    @SerializedName("summary_short")
    @Expose
    private String summaryShort;
    @SerializedName("link")
    @Expose
    private Link link;

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
}
