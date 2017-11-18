package com.diegopizzo.moviesbooks.business.network.model.movies;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by diegopizzo on 16/11/2017.
 */

public class Multimedia {

    @SerializedName("resource")
    @Expose
    private Resource resource;

    public Resource getResource() {
        return resource;
    }

    public void setResource(final Resource resource) {
        this.resource = resource;
    }

    public Multimedia withResource(final Resource resource) {
        this.resource = resource;
        return this;
    }
}
