package com.diegopizzo.moviesbooks.business.interactor;

import com.diegopizzo.moviesbooks.business.network.model.movies.MovieDetails;
import com.diegopizzo.moviesbooks.business.network.model.movies.Movies;
import com.diegopizzo.moviesbooks.business.network.service.MoviesService;
import com.diegopizzo.moviesbooks.business.network.service.ServiceConstants;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

/**
 * Created by diegopizzo on 17/11/2017.
 */

public class MoviesInteractor {

    private final MoviesService moviesService;

    public MoviesInteractor(final MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    public Single<Movies> getMoviesReviews(@NonNull final ServiceConstants.ResourceTypeMovies resourceTypeMovies,
                                           @Nullable final Integer offset,
                                           @NonNull final ServiceConstants.OrderMovies orderMovies) {

        return moviesService.getMoviesReviews(resourceTypeMovies.getValue(), offset, orderMovies.getValue());
    }


    public Single<MovieDetails> getMovieReview(final String query) {
        return moviesService.getMovieReview(query);
    }
}
