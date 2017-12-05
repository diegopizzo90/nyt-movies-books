package com.diegopizzo.moviesbooks.business.network.service;

import com.diegopizzo.moviesbooks.business.network.model.movies.MovieDetails;
import com.diegopizzo.moviesbooks.business.network.model.movies.Movies;

import io.reactivex.Single;
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
    Single<Movies> getMoviesReviews(@Path("resource-type") String resourceType, @Query("offset") Integer offset, @Query("order") String order);


    /**
     * @param query Search keywords; matches movie title and indexed terms
     *              To limit your search to exact matches only, surround your search string with single quotation marks
     *              (e.g., query='28+days+later'). Otherwise, responses will include partial matches ("head words") as
     *              well as exact matches (e.g., president will match president, presidents and presidential).
     *              If you specify multiple terms without quotation marks, they will be combined in an OR search.
     *              If you omit the query parameter, your request will be equivalent to a reviews and NYT Critics' Picks request.
     * @return movie review detail
     */
    @Headers({"Content-Type: application/json", "apikey: " + API_KEY})
    @GET("/svc/movies/v2/reviews/search.json")
    Single<MovieDetails> getMovieReview(@Query("query") String query);
}
