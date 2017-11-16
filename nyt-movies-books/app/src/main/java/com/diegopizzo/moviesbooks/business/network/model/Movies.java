package com.diegopizzo.moviesbooks.business.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by diegopizzo on 16/11/2017.
 */

public class Movies {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("num_results")
    @Expose
    private int numResults;
    @SerializedName("results")
    @Expose
    private List<Result> results = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public Movies withStatus(final String status) {
        this.status = status;
        return this;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(final String copyright) {
        this.copyright = copyright;
    }

    public Movies withCopyright(final String copyright) {
        this.copyright = copyright;
        return this;
    }

    public int getNumResults() {
        return numResults;
    }

    public void setNumResults(final int numResults) {
        this.numResults = numResults;
    }

    public Movies withNumResults(final int numResults) {
        this.numResults = numResults;
        return this;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(final List<Result> results) {
        this.results = results;
    }

    public Movies withResults(final List<Result> results) {
        this.results = results;
        return this;
    }
}
