package com.diegopizzo.moviesbooks.business.network.model.books.bookdetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by diegopizzo on 28/11/2017.
 */

public class Details {

    @SerializedName("results")
    @Expose
    private List<ResultsDetails> results;

    public List<ResultsDetails> getResults() {
        return results;
    }

    public void setResults(final List<ResultsDetails> results) {
        this.results = results;
    }

    public Details withResults(final List<ResultsDetails> results) {
        this.results = results;
        return this;
    }
}
