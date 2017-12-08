package com.diegopizzo.moviesbooks.business.network.model.books;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by diegopizzo on 28/11/2017.
 */

public class BookDetails {

    @SerializedName("title")
    @Expose
    String title;
    @SerializedName("description")
    @Expose
    String description;
    @SerializedName("author")
    @Expose
    String author;

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public BookDetails withTitle(final String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public BookDetails withDescription(final String description) {
        this.description = description;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(final String author) {
        this.author = author;
    }

    public BookDetails withAuthor(final String author) {
        this.author = author;
        return this;
    }
}
