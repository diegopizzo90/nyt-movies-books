package com.diegopizzo.moviesbooks.business.network.model.books.bestsellerlist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by diegopizzo on 18/11/2017.
 */

public class BestsellerList {

    @SerializedName("results")
    @Expose
    private Results results;

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
