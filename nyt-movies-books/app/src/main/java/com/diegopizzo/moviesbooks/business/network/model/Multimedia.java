package com.diegopizzo.moviesbooks.business.network.model;

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

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public Multimedia withResource(Resource resource) {
        this.resource = resource;
        return this;
    }
}
