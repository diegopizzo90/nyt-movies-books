package com.diegopizzo.moviesbooks.business.network.model.books;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by diegopizzo on 24/11/2017.
 */

@Parcel
public class Book {

    @SerializedName("rank")
    @Expose
    int rank;
    @SerializedName("book_image")
    @Expose
    String bookImage;
    @SerializedName("book_image_width")
    @Expose
    int bookImageWidth;
    @SerializedName("book_image_heigth")
    @Expose
    int bookImageHeight;


    public int getRank() {
        return rank;
    }

    public void setRank(final int rank) {
        this.rank = rank;
    }

    public Book withRank(final int rank) {
        this.rank = rank;
        return this;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(final String bookImage) {
        this.bookImage = bookImage;
    }

    public int getBookImageWidth() {
        return bookImageWidth;
    }

    public void setBookImageWidth(final int bookImageWidth) {
        this.bookImageWidth = bookImageWidth;
    }

    public int getBookImageHeight() {
        return bookImageHeight;
    }

    public void setBookImageHeight(final int bookImageHeight) {
        this.bookImageHeight = bookImageHeight;
    }
}
