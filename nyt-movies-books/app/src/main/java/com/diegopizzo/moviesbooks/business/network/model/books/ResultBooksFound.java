package com.diegopizzo.moviesbooks.business.network.model.books;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by diegopizzo on 09/12/2017.
 */

public class ResultBooksFound {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("isbns")
    @Expose
    private List<Isbn> isbns;

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public ResultBooksFound withTitle(final String title) {
        this.title = title;
        return this;
    }

    public List<Isbn> getIsbns() {
        return isbns;
    }

    public void setIsbns(final List<Isbn> isbns) {
        this.isbns = isbns;
    }

    public ResultBooksFound withIsbns(final List<Isbn> isbns) {
        this.isbns = isbns;
        return this;
    }
}
