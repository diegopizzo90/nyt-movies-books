package com.diegopizzo.moviesbooks.business.network.model.books.bestsellerlist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by diegopizzo on 18/11/2017.
 */

public class Results {

    @SerializedName("bestsellers_date")
    @Expose
    private String bestsellersDate;
    @SerializedName("published_date")
    @Expose
    private String publishedDate;
    @SerializedName("lists")
    @Expose
    private List<ListResults> listResults;

    public String getBestsellersDate() {
        return bestsellersDate;
    }

    public void setBestsellersDate(final String bestsellersDate) {
        this.bestsellersDate = bestsellersDate;
    }

    public Results withBestsellersDate(final String bestsellersDate) {
        this.bestsellersDate = bestsellersDate;
        return this;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(final String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Results withPublishedDate(final String publishedDate) {
        this.publishedDate = publishedDate;
        return this;
    }

    public List<ListResults> getListResults() {
        return listResults;
    }

    public void setListResults(final List<ListResults> listResults) {
        this.listResults = listResults;
    }

    public Results withListResults(final List<ListResults> listResults) {
        this.listResults = listResults;
        return this;
    }

}
