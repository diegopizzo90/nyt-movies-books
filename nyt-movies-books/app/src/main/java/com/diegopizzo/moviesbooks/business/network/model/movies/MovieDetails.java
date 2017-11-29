package com.diegopizzo.moviesbooks.business.network.model.movies;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by diegopizzo on 28/11/2017.
 */

public class MovieDetails {

    @SerializedName("results")
    @Expose
    private List<ResultDetails> results;

    public List<ResultDetails> getResults() {
        return results;
    }

    public void setResults(final List<ResultDetails> results) {
        this.results = results;
    }

    public MovieDetails withResults(final List<ResultDetails> results) {
        this.results = results;
        return this;
    }
}
