package com.diegopizzo.moviesbooks.business.network.model.books.bestsellerlist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by diegopizzo on 18/11/2017.
 */

public class ListResults {

    @SerializedName("display_name")
    @Expose
    private String displayName;
    @SerializedName("list_name_encoded")
    @Expose
    private String displayNameEncoded;
    @SerializedName("books")
    @Expose
    private List<Book> books;


    public String getDisplayNameEncoded() {
        return displayNameEncoded;
    }

    public void setDisplayNameEncoded(final String displayNameEncoded) {
        this.displayNameEncoded = displayNameEncoded;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(final String displayName) {
        this.displayName = displayName;
    }

    public ListResults withDisplayName(final String displayName) {
        this.displayName = displayName;
        return this;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(final List<Book> books) {
        this.books = books;
    }
}
