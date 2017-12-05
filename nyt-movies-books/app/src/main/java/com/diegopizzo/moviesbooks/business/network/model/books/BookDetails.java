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
    @SerializedName("price")
    @Expose
    int price;
    @SerializedName("age_group")
    @Expose
    String ageGroup;
    @SerializedName("publisher")
    @Expose
    String publisher;
    @SerializedName("primary_isbn13")
    @Expose
    String primaryIsbn13;
    @SerializedName("primary_isbn10")
    @Expose
    String primaryIsbn10;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(final int price) {
        this.price = price;
    }

    public BookDetails withPrice(final int price) {
        this.price = price;
        return this;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(final String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public BookDetails withAgeGroup(final String ageGroup) {
        this.ageGroup = ageGroup;
        return this;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(final String publisher) {
        this.publisher = publisher;
    }

    public BookDetails withPublisher(final String publisher) {
        this.publisher = publisher;
        return this;
    }

    public String getPrimaryIsbn13() {
        return primaryIsbn13;
    }

    public void setPrimaryIsbn13(final String primaryIsbn13) {
        this.primaryIsbn13 = primaryIsbn13;
    }

    public BookDetails withPrimaryIsbn13(final String primaryIsbn13) {
        this.primaryIsbn13 = primaryIsbn13;
        return this;
    }

    public String getPrimaryIsbn10() {
        return primaryIsbn10;
    }

    public void setPrimaryIsbn10(final String primaryIsbn10) {
        this.primaryIsbn10 = primaryIsbn10;
    }

    public BookDetails withPrimaryIsbn10(final String primaryIsbn10) {
        this.primaryIsbn10 = primaryIsbn10;
        return this;
    }

}
