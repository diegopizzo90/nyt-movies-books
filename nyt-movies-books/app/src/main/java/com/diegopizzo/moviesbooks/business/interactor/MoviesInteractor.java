package com.diegopizzo.moviesbooks.business.interactor;

import com.diegopizzo.moviesbooks.business.network.model.movies.Movies;
import com.diegopizzo.moviesbooks.business.network.service.MoviesService;
import com.diegopizzo.moviesbooks.business.network.service.ServiceConstants;

import io.reactivex.Observable;
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

    public Observable<Movies> getMoviesReviews(@NonNull final ServiceConstants.ResourceTypeMovies resourceTypeMovies,
                                               @Nullable final Integer offset,
                                               @NonNull final ServiceConstants.OrderMovies orderMovies) {

        return moviesService.getMoviesReviews(resourceTypeMovies.getValue(), offset, orderMovies.getValue());
    }
}
