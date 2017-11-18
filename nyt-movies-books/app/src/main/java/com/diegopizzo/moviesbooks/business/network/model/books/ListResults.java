package com.diegopizzo.moviesbooks.business.network.model.books;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by diegopizzo on 18/11/2017.
 */

public class ListResults {

    @SerializedName("list_id")
    @Expose
    private int listId;
    @SerializedName("list_name")
    @Expose
    private String listName;
    @SerializedName("display_name")
    @Expose
    private String displayName;
    @SerializedName("updated")
    @Expose
    private String updated;
    @SerializedName("list_image")
    @Expose
    private String listImage;

    public int getListId() {
        return listId;
    }

    public void setListId(final int listId) {
        this.listId = listId;
    }

    public ListResults withListId(final int listId) {
        this.listId = listId;
        return this;
    }

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

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(final String updated) {
        this.updated = updated;
    }

    public ListResults withUpdated(final String updated) {
        this.updated = updated;
        return this;
    }

    public String getListImage() {
        return listImage;
    }

    public void setListImage(final String listImage) {
        this.listImage = listImage;
    }

    public ListResults withListImage(final String listImage) {
        this.listImage = listImage;
        return this;
    }


}
