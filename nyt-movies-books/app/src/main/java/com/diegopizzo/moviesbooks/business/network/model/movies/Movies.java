package com.diegopizzo.moviesbooks.business.network.model.movies;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by diegopizzo on 16/11/2017.
 */

public class Movies {

    @SerializedName("num_results")
    @Expose
    private int numResults;
    @SerializedName("results")
    @Expose
    private List<Result> results;

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
