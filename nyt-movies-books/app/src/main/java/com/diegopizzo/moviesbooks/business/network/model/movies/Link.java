package com.diegopizzo.moviesbooks.business.network.model.movies;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by diegopizzo on 16/11/2017.
 */

public class Link {

    @SerializedName("url")
    @Expose
    String url;
    @SerializedName("suggested_link_text")
    @Expose
    String suggestedLinkText;

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public Link withUrl(final String url) {
        this.url = url;
        return this;
    }

    public String getSuggestedLinkText() {
        return suggestedLinkText;
    }

    public void setSuggestedLinkText(final String suggestedLinkText) {
        this.suggestedLinkText = suggestedLinkText;
    }

    public Link withSuggestedLinkText(final String suggestedLinkText) {
        this.suggestedLinkText = suggestedLinkText;
        return this;
    }
}
