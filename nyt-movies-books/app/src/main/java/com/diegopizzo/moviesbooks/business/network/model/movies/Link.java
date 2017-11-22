package com.diegopizzo.moviesbooks.business.network.model.movies;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by diegopizzo on 16/11/2017.
 */

public class Link implements Parcelable {

    public static final Parcelable.Creator<Link> CREATOR
            = new Parcelable.Creator<Link>() {
        @Override
        public Link createFromParcel(final Parcel in) {
            return new Link(in);
        }

        @Override
        public Link[] newArray(final int size) {
            return new Link[size];
        }
    };

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("suggested_link_text")
    @Expose
    private String suggestedLinkText;

    private Link(final Parcel in) {
        url = in.readString();
        suggestedLinkText = in.readString();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeString(url);
        dest.writeString(suggestedLinkText);
    }
}
