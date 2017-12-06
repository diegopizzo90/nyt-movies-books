package com.diegopizzo.moviesbooks.business.interactor;

import com.diegopizzo.moviesbooks.business.network.cache.MoviesStore;
import com.diegopizzo.moviesbooks.business.network.model.movies.MovieDetails;
import com.diegopizzo.moviesbooks.business.network.model.movies.Movies;
import com.diegopizzo.moviesbooks.business.network.service.ServiceConstants;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

/**
 * Created by diegopizzo on 17/11/2017.
 */

public class MoviesInteractor {

    private final MoviesStore moviesStore;

    public MoviesInteractor(final MoviesStore moviesStore) {
        this.moviesStore = moviesStore;
    }

    public Single<Movies> getMoviesReviews(@Nullable final Integer offset,
                                           @NonNull final ServiceConstants.OrderMovies orderMovies) {

        return moviesStore.storeData(offset.toString() + ";" + orderMovies.getValue());
    }


    public Single<MovieDetails> getMovieReview(final String query) {
        return moviesStore.storeDataDetail(query);
    }
}
