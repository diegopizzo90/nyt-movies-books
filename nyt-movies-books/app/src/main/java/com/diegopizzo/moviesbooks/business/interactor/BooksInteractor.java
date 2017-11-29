package com.diegopizzo.moviesbooks.business.interactor;

import com.diegopizzo.moviesbooks.business.network.model.books.BestsellerList;
import com.diegopizzo.moviesbooks.business.network.model.books.Details;
import com.diegopizzo.moviesbooks.business.network.service.BooksService;

import io.reactivex.Single;
import io.reactivex.annotations.Nullable;

/**
 * Created by diegopizzo on 18/11/2017.
 */

public class BooksInteractor {
    private final BooksService booksService;

    public BooksInteractor(final BooksService booksService) {
        this.booksService = booksService;
    }

    public Single<BestsellerList> getBestSellerLists(@Nullable final String publishedDate) {
        return booksService.getBestSellerList(publishedDate);
    }

    public Single<Details> getBookDetails(final Integer isbn, final String listName) {
        return booksService.getBookDetails(isbn, listName);
    }
}
