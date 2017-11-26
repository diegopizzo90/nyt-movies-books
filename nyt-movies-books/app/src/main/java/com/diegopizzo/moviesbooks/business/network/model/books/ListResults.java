package com.diegopizzo.moviesbooks.business.network.model.books;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

/**
 * Created by diegopizzo on 18/11/2017.
 */

@Parcel
public class ListResults {

    @SerializedName("list_name")
    @Expose
    String listName;
    @SerializedName("display_name")
    @Expose
    String displayName;
    @SerializedName("books")
    @Expose
    List<Book> books;

    public String getListName() {
        return listName;
    }

    public void setListName(final String listName) {
        this.listName = listName;
    }

    public ListResults withListName(final String listName) {
        this.listName = listName;
        return this;
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
