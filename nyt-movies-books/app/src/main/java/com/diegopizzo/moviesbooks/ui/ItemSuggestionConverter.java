package com.diegopizzo.moviesbooks.ui;

import android.text.TextUtils;

import com.diegopizzo.moviesbooks.business.network.model.books.booksearchable.BooksFound;
import com.diegopizzo.moviesbooks.business.network.model.books.booksearchable.ResultBooksFound;
import com.diegopizzo.moviesbooks.business.network.model.movies.moviesreviewsdetails.MovieDetails;
import com.diegopizzo.moviesbooks.business.network.model.movies.moviesreviewsdetails.ResultDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by diegopizzo on 12/12/2017.
 */

public class ItemSuggestionConverter {

    private final MovieDetails movieDetails;
    private final BooksFound booksFound;

    public ItemSuggestionConverter(final MovieDetails movieDetails, final BooksFound booksFound) {
        this.movieDetails = movieDetails;
        this.booksFound = booksFound;
    }

    public List<ItemSuggestion> createSuggestionList() {
        final List<ItemSuggestion> itemSuggestionList = new ArrayList<>();
        final List<ResultDetails> resultDetailsMoviesList = movieDetails.getResults();
        final List<ResultBooksFound> resultBooksFoundList = booksFound.getResults();
        if (resultDetailsMoviesList != null) {
            for (final ResultDetails resultDetails : resultDetailsMoviesList) {
                if (!TextUtils.isEmpty(resultDetails.getDisplayTitle())) {
                    final String movieTitle = resultDetails.getDisplayTitle();
                    final ItemSuggestion itemSuggestionMovie = new ItemSuggestion(movieTitle, ItemSuggestion.TypeItem.MOVIE);
                    itemSuggestionList.add(itemSuggestionMovie);
                }
            }
        }

        if (resultBooksFoundList != null) {
            for (final ResultBooksFound resultBooksFound : resultBooksFoundList) {
                if (!TextUtils.isEmpty(resultBooksFound.getTitle())) {
                    final String bookTitle = resultBooksFound.getTitle();
                    final ItemSuggestion itemSuggestionBook = new ItemSuggestion(bookTitle, ItemSuggestion.TypeItem.BOOK);
                    itemSuggestionList.add(itemSuggestionBook);
                }
            }
        }
        return itemSuggestionList;
    }
}
