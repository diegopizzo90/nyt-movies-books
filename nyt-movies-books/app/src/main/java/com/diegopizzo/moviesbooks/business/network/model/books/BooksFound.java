package com.diegopizzo.moviesbooks.business.network.model.books;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by diegopizzo on 09/12/2017.
 */

public class BooksFound {

    @SerializedName("results")
    @Expose
    private List<ResultBooksFound> results;

    public List<ResultBooksFound> getResults() {
        return results;
    }

    public void setResults(final List<ResultBooksFound> results) {
        this.results = results;
    }

    public BooksFound withResults(final List<ResultBooksFound> results) {
        this.results = results;
        return this;
    }

}
