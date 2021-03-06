package com.diegopizzo.moviesbooks.business.network.service;

import com.diegopizzo.moviesbooks.business.network.model.books.bestsellerlist.BestsellerList;
import com.diegopizzo.moviesbooks.business.network.model.books.bookdetails.Details;
import com.diegopizzo.moviesbooks.business.network.model.books.booksearchable.BooksFound;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

import static com.diegopizzo.moviesbooks.business.network.service.ServiceConstants.API_KEY;

/**
 * Created by diegopizzo on 18/11/2017.
 */

public interface BooksService {

    /**
     * @param publishedDate The best-seller list publication date. YYYY-MM-DD
     *                      You do not have to specify the exact date the list was published. The service will search forward (into the future) for the closest publication date to the date you specify.
     *                      For example, a request for lists/overview/2013-05-22 will retrieve the list that was published on 05-26.
     *                      If you do not include a published_date, the current week's best-sellers lists will be returned.
     * @return bestseller list with their best books
     */
    @Headers({"Content-Type: application/json", "apikey: " + API_KEY})
    @GET("/svc/books/v3/lists/overview.json")
    Single<BestsellerList> getBestSellerList(@Query("published_date") String publishedDate);


    /**
     * @param isbn     International Standard Book Number, 10 or 13 digits
     * @param listName The name of the Times best-seller list. To get valid values, use a list names request.
     *                 Be sure to replace spaces with hyphens (e.g., e-book-fiction or hardcover-fiction, not E-Book Fiction or Hardcover Fiction).
     *                 (The parameter is not case sensitive.)
     * @return book details
     */
    @Headers({"Content-Type: application/json", "apikey: " + API_KEY})
    @GET("/svc/books/v3/lists//.json")
    Single<Details> getBookDetails(@Query("isbn") String isbn, @Query("list-name") String listName);


    /**
     * @param title The title of the best seller. When searching, you can specify a portion of a title or a full title.
     * @return one or list of bestsellers
     */
    @Headers({"Content-Type: application/json", "apikey: " + API_KEY})
    @GET("/svc/books/v3/lists/best-sellers/history.json")
    Single<BooksFound> findBestsellers(@Query("title") String title);
}
