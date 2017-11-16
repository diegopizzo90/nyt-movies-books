package com.diegopizzo.moviesbooks.business.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by diegopizzo on 16/11/2017.
 */

public class Link {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("suggested_link_text")
    @Expose
    private String suggestedLinkText;

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public Link withType(final String type) {
        this.type = type;
        return this;
    }

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
