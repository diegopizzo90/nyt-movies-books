package com.diegopizzo.moviesbooks.business.network.model.books.booksearchable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by diegopizzo on 09/12/2017.
 */

public class Isbn {

    @SerializedName("isbn10")
    @Expose
    private String isbn10;
    @SerializedName("isbn13")
    @Expose
    private String isbn13;

    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(final String isbn10) {
        this.isbn10 = isbn10;
    }

    public Isbn withIsbn10(final String isbn10) {
        this.isbn10 = isbn10;
        return this;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(final String isbn13) {
        this.isbn13 = isbn13;
    }

    public Isbn withIsbn13(final String isbn13) {
        this.isbn13 = isbn13;
        return this;
    }

}