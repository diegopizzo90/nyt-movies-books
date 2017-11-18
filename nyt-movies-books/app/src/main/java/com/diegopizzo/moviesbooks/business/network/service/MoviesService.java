package com.diegopizzo.moviesbooks.business.network.service;

import com.diegopizzo.moviesbooks.business.network.model.movies.Movies;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static com.diegopizzo.moviesbooks.business.network.service.ServiceConstants.API_KEY;

/**
 * Created by diegopizzo on 17/11/2017.
 */

public interface MoviesService {

    /**
     * @param resourceType [all,picks] Specify all to retrieve all reviews, including NYT Critics' Picks.
     *                     Specify picks to get NYT Critics' Picks currently in theaters.
     * @param offset       Positive integer, multiple of 20
     * @param order        [by-title, by-publication-date, by-opening-date] Sets the sort order of the results.
     *                     Results ordered by-title are in ascending alphabetical order. Results ordered by one of the date parameters are in reverse chronological order.
     *                     If you do not specify a sort order, the results will be ordered by publication-date.
     * @return observable of movies
     */
    @Headers({"Content-Type: application/json", "apikey: " + API_KEY})
    @GET("/svc/movies/v2/reviews/{resource-type}.json")
    Observable<Movies> getMoviesReviews(@Path("resource-type") String resourceType, @Query("offset") Integer offset, @Query("order") String order);
}
