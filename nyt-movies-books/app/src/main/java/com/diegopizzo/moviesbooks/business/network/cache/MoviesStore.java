package com.diegopizzo.moviesbooks.business.network.cache;

import com.diegopizzo.moviesbooks.business.network.model.movies.Movies;
import com.diegopizzo.moviesbooks.business.network.service.MoviesService;
import com.diegopizzo.moviesbooks.business.network.service.ServiceConstants;
import com.nytimes.android.external.store3.base.impl.Store;
import com.nytimes.android.external.store3.base.impl.StoreBuilder;

import io.reactivex.Single;

/**
 * Created by diegopizzo on 05/12/2017.
 */

public class MoviesStore {

    private final Store<Movies, String> store;
    private final MoviesService moviesService;

    public MoviesStore(final MoviesService moviesService) {
        this.moviesService = moviesService;

        store = StoreBuilder.<String, Movies>key()
                .fetcher(key ->
                        moviesService.getMoviesReviews(ServiceConstants.ResourceTypeMovies.ALL.getValue(),
                                Integer.parseInt(key.split(";")[0]),
                                key.split(";")[1]))
                .open();
    }

    public Single<Movies> storeData(final String key) {
        return store.get(key);
    }
}
