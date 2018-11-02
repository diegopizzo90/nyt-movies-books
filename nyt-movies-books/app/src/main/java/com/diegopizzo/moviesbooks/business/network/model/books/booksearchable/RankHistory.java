package com.diegopizzo.moviesbooks.business.network.model.books.booksearchable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by diegopizzo on 12/12/2017.
 */

public class RankHistory {

    @SerializedName("list_name")
    @Expose
    private String listName;

    public String getListName() {
        return listName;
    }

    public void setListName(final String listName) {
        this.listName = listName;
    }

    public RankHistory withListName(final String listName) {
        this.listName = listName;
        return this;
    }
}