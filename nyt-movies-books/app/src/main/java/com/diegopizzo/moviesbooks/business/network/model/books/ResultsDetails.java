package com.diegopizzo.moviesbooks.business.network.model.books;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

/**
 * Created by diegopizzo on 28/11/2017.
 */

@Parcel
public class ResultsDetails {

    @SerializedName("amazon_product_url")
    @Expose
    String amazonProductUrl;
    @SerializedName("book_details")
    @Expose
    List<BookDetails> bookDetails;

    public String getAmazonProductUrl() {
        return amazonProductUrl;
    }

    public void setAmazonProductUrl(final String amazonProductUrl) {
        this.amazonProductUrl = amazonProductUrl;
    }

    public ResultsDetails withAmazonProductUrl(final String amazonProductUrl) {
        this.amazonProductUrl = amazonProductUrl;
        return this;
    }

    public List<BookDetails> getBookDetails() {
        return bookDetails;
    }

    public void setBookDetails(final List<BookDetails> bookDetails) {
        this.bookDetails = bookDetails;
    }

    public ResultsDetails withBookDetails(final List<BookDetails> bookDetails) {
        this.bookDetails = bookDetails;
        return this;
    }
}
