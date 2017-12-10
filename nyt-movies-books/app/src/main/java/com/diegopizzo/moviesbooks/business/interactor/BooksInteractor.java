package com.diegopizzo.moviesbooks.business.interactor;

import com.diegopizzo.moviesbooks.business.network.cache.BooksStore;
import com.diegopizzo.moviesbooks.business.network.model.books.bestsellerlist.BestsellerList;
import com.diegopizzo.moviesbooks.business.network.model.books.bookdetails.Details;
import com.diegopizzo.moviesbooks.business.network.model.books.booksearchable.BooksFound;

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

    public Single<Details> getBookDetails(final String isbn, final String listName) {
        return booksStore.storeDataDetail(isbn + ";" + listName);
    }

    public Single<BooksFound> findBestsellers(final String title) {
        return booksStore.storeDataSearched(title);
    }
}
