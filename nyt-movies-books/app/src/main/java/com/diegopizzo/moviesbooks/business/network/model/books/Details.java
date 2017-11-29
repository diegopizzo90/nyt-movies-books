package com.diegopizzo.moviesbooks.business.network.model.books;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

/**
 * Created by diegopizzo on 28/11/2017.
 */

@Parcel
public class Details {

    @SerializedName("results")
    @Expose
    List<ResultsDetails> results;

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
