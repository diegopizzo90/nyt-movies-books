package com.diegopizzo.moviesbooks.ui.itemdetailsactivity;

import android.util.Log;

import com.diegopizzo.moviesbooks.business.interactor.BooksInteractor;
import com.diegopizzo.moviesbooks.business.interactor.MoviesInteractor;
import com.diegopizzo.moviesbooks.business.network.model.books.bookdetails.Details;
import com.diegopizzo.moviesbooks.business.network.model.books.bookdetails.ResultsDetails;
import com.diegopizzo.moviesbooks.business.network.model.movies.moviesreviewsdetails.MovieDetails;
import com.diegopizzo.moviesbooks.business.network.model.movies.moviesreviewsdetails.ResultDetails;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by diegopizzo on 27/11/2017.
 */

public class ItemDetailsActivityPresenter implements ItemDetailsActivityContract.Presenter {

    private final ItemDetailsActivityContract.View view;
    private final MoviesInteractor moviesInteractor;
    private final BooksInteractor booksInteractor;

    public ItemDetailsActivityPresenter(final ItemDetailsActivityContract.View view, final MoviesInteractor moviesInteractor, final BooksInteractor booksInteractor) {
        this.view = view;
        this.moviesInteractor = moviesInteractor;
        this.booksInteractor = booksInteractor;
    }


    @Override
    public void getSelectedMovieDetails(final String query) {
        final Single<MovieDetails> movieDetailsSingle = moviesInteractor.getMovieReview(query);
        movieDetailsSingle.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> view.showLoading())
                .doFinally(view::showContent)
                .subscribe(movieDetails -> {
                    if (movieDetails != null && movieDetails.getResults() != null) {
                        final ResultDetails resultDetails = movieDetails.getResults().get(0);
                        view.setDataOfMovieReview(resultDetails);
                    } else {
                        view.showMessage("Movie not available");
                    }
                }, throwable -> {
                    view.showContent();
                    view.showMessage("Errore " + throwable.getMessage());
                    Log.e("error", throwable.getMessage());
                });
    }


    @Override
    public void getSelectedBookDetails(final String isbn, final String listName, final String imageBook) {
        final Single<Details> bookDetailsSingle = booksInteractor.getBookDetails(isbn, listName);
        bookDetailsSingle.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> view.showLoading())
                .doFinally(view::showContent)
                .subscribe(bookDetails -> {
                    if (bookDetails != null && bookDetails.getResults() != null
                            && !bookDetails.getResults().isEmpty() && bookDetails.getResults().get(0) != null
                            && bookDetails.getResults().get(0).getBookDetails() != null) {

                        final ResultsDetails resultDetails = bookDetails.getResults().get(0);
                        final String amazonLink = resultDetails.getAmazonProductUrl();
                        view.setDataOfBook(resultDetails.getBookDetails().get(0), amazonLink, imageBook);
                    } else {
                        view.showMessage("Book not available");
                    }
                }, throwable -> {
                    view.showContent();
                    view.showMessage("Item Selected Error " + throwable.getMessage());
                    Log.e("Item Selected Error", throwable.getMessage());
                });
    }

}
