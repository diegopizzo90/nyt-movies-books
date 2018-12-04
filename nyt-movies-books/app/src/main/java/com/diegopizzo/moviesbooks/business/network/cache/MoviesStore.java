package com.diegopizzo.moviesbooks.business.network.cache;

import com.diegopizzo.moviesbooks.business.network.model.movies.moviesreviews.Movies;
import com.diegopizzo.moviesbooks.business.network.model.movies.moviesreviewsdetails.MovieDetails;
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
    private final Store<MovieDetails, String> storeDetails;
    private final MoviesService moviesService;

    public MoviesStore(final MoviesService moviesService) {
        this.moviesService = moviesService;

        store = StoreBuilder.<String, Movies>key()
                .fetcher(key ->
                        moviesService.getMoviesReviews(ServiceConstants.ResourceTypeMovies.PICKS.getValue(),
                                Integer.parseInt(key.split(";")[0]),
                                key.split(";")[1]))
                .open();

        storeDetails = StoreBuilder.<String, MovieDetails>key()
                .fetcher(moviesService::getMovieReview)
                .open();
    }

    public Single<Movies> storeData(final String key) {
        return store.get(key);
    }

    public Single<MovieDetails> storeDataDetail(final String key) {
        return storeDetails.get(key);
    }
}
