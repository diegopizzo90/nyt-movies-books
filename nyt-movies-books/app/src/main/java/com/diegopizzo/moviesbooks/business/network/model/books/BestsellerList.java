package com.diegopizzo.moviesbooks.business.network.model.books;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by diegopizzo on 18/11/2017.
 */

public class BestsellerList {

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
    private Results results;

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public BestsellerList withStatus(final String status) {
        this.status = status;
        return this;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(final String copyright) {
        this.copyright = copyright;
    }

    public BestsellerList withCopyright(final String copyright) {
        this.copyright = copyright;
        return this;
    }

    public int getNumResults() {
        return numResults;
    }

    public void setNumResults(final int numResults) {
        this.numResults = numResults;
    }

    public BestsellerList withNumResults(final int numResults) {
        this.numResults = numResults;
        return this;
    }

    public Results getResults() {
        return results;
    }

    public void setResults(final Results results) {
        this.results = results;
    }

    public BestsellerList withResults(final Results results) {
        this.results = results;
        return this;
    }
}
