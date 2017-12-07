package com.diegopizzo.moviesbooks.business.network.cache;

import com.diegopizzo.moviesbooks.business.network.model.books.BestsellerList;
import com.diegopizzo.moviesbooks.business.network.model.books.Details;
import com.diegopizzo.moviesbooks.business.network.service.BooksService;
import com.nytimes.android.external.store3.base.impl.Store;
import com.nytimes.android.external.store3.base.impl.StoreBuilder;

import io.reactivex.Single;

/**
 * Created by diegopizzo on 05/12/2017.
 */

public class BooksStore {

    private final Store<BestsellerList, String> store;
    private final Store<Details, String> storeDetails;
    private final BooksService booksService;

    public BooksStore(final BooksService booksService) {
        this.booksService = booksService;

        store = StoreBuilder.<String, BestsellerList>key()
                .fetcher(key -> booksService.getBestSellerList(null))
                .open();

        storeDetails = StoreBuilder.<String, Details>key()
                .fetcher(key -> booksService.getBookDetails(key.split(";")[0], key.split(";")[1]))
                .open();
    }

    public Single<BestsellerList> storeData(final String key) {
        return store.get(key);
    }

    public Single<Details> storeDataDetail(final String key) {
        return storeDetails.get(key);
    }

}
