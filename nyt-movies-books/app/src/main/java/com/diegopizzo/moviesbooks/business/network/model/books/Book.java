package com.diegopizzo.moviesbooks.business.network.model.books;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by diegopizzo on 24/11/2017.
 */

public class Book {

    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("rank")
    @Expose
    private int rank;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("book_image")
    @Expose
    private String bookImage;
    @SerializedName("book_image_width")
    @Expose
    private int bookImageWidth;
    @SerializedName("book_image_heigth")
    @Expose
    private int bookImageHeight;


    public String getAuthor() {
        return author;
    }

    public void setAuthor(final String author) {
        this.author = author;
    }

    public Book withAuthor(final String author) {
        this.author = author;
        return this;
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public Book withTitle(final String title) {
        this.title = title;
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
