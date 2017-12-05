package com.diegopizzo.moviesbooks.business.interactor;

import com.diegopizzo.moviesbooks.business.network.cache.BooksStore;
import com.diegopizzo.moviesbooks.business.network.model.books.BestsellerList;

import io.reactivex.Single;
import io.reactivex.annotations.Nullable;

/**
 * Created by diegopizzo on 18/11/2017.
 */

public class BooksInteractor {
    private final BooksStore booksStore;

    public BooksInteractor(final BooksStore booksStore) {
        this.booksStore = booksStore;
    }

    public Single<BestsellerList> getBestSellerLists(@Nullable final String publishedDate) {
        return booksStore.storeData("KEY");
    }

    /*public Single<Details> getBookDetails(final Integer isbn, final String listName) {
        return booksService.getBookDetails(isbn, listName);
    }*/
}
